package com.ebs.broker.network;

import com.ebs.broker.model.Publication;
import com.ebs.broker.model.RoutingTableEntry;
import com.ebs.broker.model.Subscription;
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

  public boolean handleSubscription(Subscription subscription) {
    routingTable.add(new RoutingTableEntry(subscription, myIp));
    // TODO:create identity routing
    // give to other nodes
    return true;
  }

  public boolean handlePublication(List<Publication> publicationList, String brokerIp) {
    // TODO:create identity routing
    // verify subscriptions with all publications
    // send it to my matching subscribers
    // else send it forward if match
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
