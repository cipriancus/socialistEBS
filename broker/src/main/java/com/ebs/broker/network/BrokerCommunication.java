package com.ebs.broker.network;

import com.ebs.broker.model.ConverterService;
import com.ebs.broker.model.pojo.Publication;
import com.ebs.broker.model.RoutingTableEntry;
import com.ebs.broker.model.pojo.Subscription;
import com.ebs.broker.service.ComparerService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;
import java.util.*;

public class BrokerCommunication {
  private final String HTTP = "http://";

  private final String PING_URL = "/private/ping";

  private final String JOIN_URL = "/private/join_network";

  private final String PROPAGATE_SUBSCRIPTION = "/private/propagate_subscription";

  private final String PROPAGATE_PUBLICATION = "/private/propagate_publication";

  private final String SUBSCRIBER_CALLBACK = "/publication";

  private List<RoutingTableEntry> routingTable;

  private Set<String> localClients;

  @Value("${server.self-identity}")
  private String myIp;

  @Value("${server.broker-list}")
  private String brokerStringList;

  @Autowired private RestTemplate restTemplate;
  private List<String> knownBrokers;

  public BrokerCommunication() {
    knownBrokers = new ArrayList<>();
    routingTable = new ArrayList<>();
    localClients = new HashSet<>();
  }

  @PostConstruct
  private void populateKnownBrokers() {
    String brokerList[] = brokerStringList.split(",");
    for (String iterator : brokerList) {
      if (!iterator.equals(myIp)
          && isNotInKnownBrokers(iterator)
          && sendJoinNetworkRequest(iterator)) {
        knownBrokers.add(iterator);
      }
    }
  }

  @Scheduled(cron = "0/60 * * * * *")
  public void pingKnownBrokers() {
    Iterator<String> iterator = knownBrokers.iterator();
    while (iterator.hasNext()) {
      String ip = iterator.next();
      if (ping(ip) != true) {
        iterator.remove();
      } else {
        System.out.println("Broker has responded " + ip);
      }
    }
    for (String knownBroker : knownBrokers) {
      System.out.println("I know broker " + knownBroker);
    }
  }

  public void addLocalClient(String ip) {
    localClients.add(ip);
  }

  public boolean joinNetwork(String ipAddress) {
    if (isNotInKnownBrokers(ipAddress) == true) {
      knownBrokers.add(ipAddress);
      return true;
    }
    return false;
  }

  public boolean ping(String ipAddress) {
    try {
      String response =
              restTemplate.getForEntity(HTTP + ipAddress + PING_URL, String.class).getBody();
      if (Strings.isNullOrEmpty(response)) {
        return true;
      }
    } catch (RestClientException e) {
      // doesn't matter what exception, but it's dead
      return false;
    } catch (Exception e) {
      // doesn't matter what exception
      return false;
    }
    return true;
  }

  public boolean sendJoinNetworkRequest(String ipAddress) {
    try {
      HttpEntity<?> httpEntity = new HttpEntity<Object>(myIp, new HttpHeaders());

      ResponseEntity response =
          restTemplate.exchange(
              HTTP + ipAddress + JOIN_URL, HttpMethod.POST, httpEntity, String.class);
      if (response.getStatusCode() == HttpStatus.OK) {
        return true;
      }
    } catch (RestClientException e) {
      // doesn't matter what exception, but it's dead
      return false;
    } catch (Exception e) {
      // doesn't matter what exception
      return false;
    }
    return true;
  }

  public Set<RoutingTableEntry> administer(Subscription subscription, String clientIp) {
    /*
       	begin{
    	Ms=0/
    	forall F in S do{
    		// se steng din tabela de rutare toate subscriptiile echivalente F si destinatia lui
    		if source(m) E NB {
    			Tb=Tb-CbI(F,source(m));//CbI(F,D)={(G,D)ETb ^ F =G} un set de filtre din tabela de rutare Tb ce sunt echivalente F=G si au aceeasi destinatie D
    		}else{
    			Tb=Tb-{(F,source(m))};//F si clientul
    		}
    		A={(F,H) H E DbI(F)-{source(m)}} // trimit subscriptia la toti brokerii vecini mai putin de unde a venit
    		//set de vecini ai lui B ce pot fi destinatii in Tb a,i pentru fiecare broker sa nu existe alt broker destinatie in Tb pentru o subscriptie echivalenta pt F

    		Ms=Ms U A
    		Tb=Tb U{(F,source(m))}
    	}
    }
    return Ms;
    */
    if (knownBrokers.contains(clientIp)) {
      eraseEquivalentFilters(subscription, clientIp);
    } else {
      eraseFromTb(subscription, clientIp); // Tb=Tb-{(F,source(m))};//F si client
    }
    Set<RoutingTableEntry> a = dbi(subscription, clientIp);
    routingTable.add(new RoutingTableEntry(subscription, clientIp)); // Tb=Tb U{(F,source(m))}
    return a; // return ms/a
  }

  public boolean handleAdminMessage(Set<RoutingTableEntry> subscriptionSet, String clientIp) {
    /*
       	forall H in BN-{d} {
    	S={F|(F,H) in FS}
    	if(S!=0/){
    		propagate_subscription(H,S)
    	}
    }
        */
    for (RoutingTableEntry iterator : subscriptionSet) {
      if (iterator.getSubscription() != null && iterator.getBrokerIp() != null) {
        if (propagateSubscription(iterator.getSubscription(), iterator.getBrokerIp()) == false) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean handleNotification(Publication publication, String brokerIp) {
    /*
       matching_nodes = destinatins(match(FB,n));
    // toate nodurile destinati mai putin D intersectat cu brokerii vecini
    forall(Bi in ((matching_nodes-{D}) intersectat NB)){
    	propagate_publication(Bi) // send(Bi,"forward(n)"); //PrivateBrokerController /propagate_publication
    	// notifice alt nod care ar trebui sa apeleze tot handle notification
    }

    //din multimea de noduri ce fac match cu notificarea n
    //se vad care noduri sunt sunt in multimea locala de clienti a brokerului curent
    forall(C in (matching_nodes intersectat LB)){
    	notify(C,n) --> notifica clientul de notificarea n
    }
        */
    Set<String> matchingNodes = destinations(match(publication, brokerIp));
    for (String iterator : matchingNodes) {
      if (knownBrokers.contains(iterator) && iterator.equals(brokerIp) == false) {
        if (propagatePublication(publication, iterator) == false) {
          return false;
        }
      }
    }

    for (String iterator : matchingNodes) {
      if (localClients.contains(iterator)) {
        if (notify(publication, iterator) == false) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean notify(Publication publication, String clientIP) {
    try {
      MultiValueMap<String, String> headers = new HttpHeaders();
      HttpEntity<String> request =
          new HttpEntity<>(ConverterService.getProtoStringFromPublication(publication), headers);

      ResponseEntity<String> response =
          restTemplate.postForEntity(HTTP + clientIP + SUBSCRIBER_CALLBACK, request, String.class);

      if (response.getStatusCode() == HttpStatus.OK) {
        return true;
      }
    } catch (RestClientException exception) {
      exception.printStackTrace();
      return false;
    }
    return false;
  }

  public boolean propagatePublication(Publication publication, String brokerIp) {
    try {
      MultiValueMap<String, String> headers = new HttpHeaders();
      headers.put("broker_ip", Arrays.asList(myIp));
      HttpEntity<String> request =
          new HttpEntity<>(ConverterService.getProtoStringFromPublication(publication), headers);

      ResponseEntity<String> response =
          restTemplate.postForEntity(
              HTTP + brokerIp + PROPAGATE_PUBLICATION, request, String.class);

      if (response.getStatusCode() == HttpStatus.OK) {
        return true;
      }
    } catch (RestClientException exception) {
      exception.printStackTrace();
      return false;
    }
    return false;
  }

  public boolean propagateSubscription(Subscription subscription, String brokerIp) {
    try {
      MultiValueMap<String, String> headers = new HttpHeaders();
      headers.put("broker_ip", Arrays.asList(myIp));
      HttpEntity<String> request =
          new HttpEntity<>(ConverterService.getProtoStringFromSubscription(subscription), headers);

      ResponseEntity<String> response =
          restTemplate.postForEntity(
              HTTP + brokerIp + PROPAGATE_SUBSCRIPTION, request, String.class);

      if (response.getStatusCode() == HttpStatus.OK) {
        return true;
      }
    } catch (RestClientException exception) {
      exception.printStackTrace();
      return false;
    }
    return false;
  }

  private boolean isNotInKnownBrokers(String ipAddress) {
    for (String iterator : knownBrokers) {
      if (iterator.equals(ipAddress)) {
        return false;
      }
    }
    return true;
  }

  private void eraseEquivalentFilters(Subscription subscription, String clientIp) {
    Iterator<RoutingTableEntry> iterator = routingTable.iterator();

    while (iterator.hasNext()) {
      RoutingTableEntry routingTableEntry = iterator.next();

      if (routingTableEntry.getBrokerIp().equals(clientIp)
          && routingTableEntry.getSubscription().equals(subscription)) {
        iterator.remove();
      }
    }
  }

  private void eraseFromTb(Subscription subscription, String clientIp) {
    Iterator<RoutingTableEntry> iterator = routingTable.iterator();

    while (iterator.hasNext()) {
      RoutingTableEntry routingTableEntry = iterator.next();

      if (routingTableEntry.getBrokerIp().equals(clientIp)
          && routingTableEntry.getSubscription().equals(subscription)) {
        iterator.remove();
      }
    }
  }

  private Set<RoutingTableEntry> dbi(Subscription subscription, String clientIp) {
    Set<RoutingTableEntry> sendBrokers = new HashSet<>();
    for (String iterator : knownBrokers) {
      if (iterator.equals(clientIp) == false) {
        RoutingTableEntry newEntity = new RoutingTableEntry(subscription, iterator);
        if (!routingTable.contains(newEntity)) { // daca nu mai exista "filtrul" in Tb
          sendBrokers.add(newEntity);
        }
      }
    }
    return sendBrokers;
  }

  private Set<String> destinations(Set<RoutingTableEntry> set) {
    Set<String> ips = new HashSet<>();
    for (RoutingTableEntry iterator : set) {
      ips.add(iterator.getBrokerIp());
    }
    return ips;
  }

  private Set<RoutingTableEntry> match(Publication publication, String brokerIp) {
    Set<RoutingTableEntry> matchingSubscription = new HashSet<>();
    for (RoutingTableEntry iterator : routingTable) {
      if (ComparerService.compare(iterator.getSubscription(), publication)) {
        matchingSubscription.add(iterator);
      }
    }
    return matchingSubscription;
  }
}
