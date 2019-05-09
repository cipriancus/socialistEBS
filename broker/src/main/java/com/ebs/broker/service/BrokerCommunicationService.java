package com.ebs.broker.service;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerCommunicationService {

  private List<String> knownBrokers;

  @Autowired private RestTemplate restTemplate;

  public BrokerCommunicationService() {
    knownBrokers = new ArrayList<>();
  }

  public boolean joinNetwork(String ipAddress) {
    if (ping(ipAddress) == true) {
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
}
