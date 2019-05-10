package com.ebs.broker.service;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BrokerCommunicationService {

  @Value("server.self-identity")
  private String myIp;

  @Value("server.broker-list")
  private String brokerStringList;

  @Autowired private RestTemplate restTemplate;
  private List<String> knownBrokers;

  public BrokerCommunicationService() {
    knownBrokers = new ArrayList<>();
    populateKnownBrokers();
  }

  @Scheduled(cron = "* 1 * * * *")
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
      String response = restTemplate.getForEntity(ipAddress, String.class).getBody();
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
      ResponseEntity<String> response = restTemplate.postForEntity(ipAddress, null, String.class);
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

  private boolean isNotInKnownBrokers(String ipAddress) {
    for (String iterator : knownBrokers) {
      if (iterator.equals(ipAddress)) {
        return false;
      }
    }
    return true;
  }
}
