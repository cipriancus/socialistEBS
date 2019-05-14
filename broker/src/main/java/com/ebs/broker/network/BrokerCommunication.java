package com.ebs.broker.network;

import com.ebs.broker.model.pojo.Publication;
import com.ebs.broker.model.RoutingTableEntry;
import com.ebs.broker.model.pojo.Subscription;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrokerCommunication {
  private final String HTTP = "http://";

  private final String PING_URL = "/private/ping";

  private final String JOIN_URL = "/private/join_network";

  private List<RoutingTableEntry> routingTable;

  @Value("${server.self-identity}")
  private String myIp;

  @Value("${server.broker-list}")
  private String brokerStringList;

  @Autowired private RestTemplate restTemplate;
  private List<String> knownBrokers;

  public BrokerCommunication() {
    knownBrokers = new ArrayList<>();
    routingTable = new ArrayList<>();
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
  }

  public boolean joinNetwork(String ipAddress) {
    if (ping(ipAddress) == true && isNotInKnownBrokers(ipAddress) == true) {
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
      MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
      body.add("ipAddress", ipAddress);
      HttpEntity<?> httpEntity = new HttpEntity<Object>(body, new HttpHeaders());

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

//  public boolean handleSubscription(Subscription subscription, String clientIP) {
//    routingTable.add(new RoutingTableEntry(subscription, clientIP));
//    // TODO:create identity routing
//    // give to other nodes
//    return true;
//  }

  public Set<Subscription> administer(Subscription subscription, String clientIp) {
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
    return null;
  }

  public boolean handleAdminMessage(Set<Subscription> subscriptionSet, String clientIp) {
    /*
       	forall H in BN-{d} {
    	S={F|(F,H) in FS}
    	if(S!=0/){
    		propagate_subscription(H,S)
    	}
    }
        */
    return true;
  }

  public boolean handleNotification(Publication publicationList, String brokerIp) {
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
    return true;
  }

  public boolean propagatePublication(Publication publication, String brokerIp) {
    //	send(Bi,n)
    return true;
  }

  public boolean propagateSubscription(Subscription subscription, String brokerIp) {
    //	send(Bi,s)
    return true;
  }

  private boolean isNotInKnownBrokers(String ipAddress) {
    for (String iterator : knownBrokers) {
      if (iterator.equals(ipAddress)) {
        return false;
      }
    }
    return true;
  }
}
