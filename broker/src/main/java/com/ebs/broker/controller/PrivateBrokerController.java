package com.ebs.broker.controller;

import com.ebs.broker.service.BrokerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/** Used to communicate with other brokers */
@RestController("/private")
public class PrivateBrokerController {
  @Autowired private BrokerCommunicationService brokerCommunicationService;

  @PostMapping("/join_network")
  public boolean joinNetwork(String ipAddress) {
    return brokerCommunicationService.joinNetwork(ipAddress);
  }

  @GetMapping("ping")
  public String pint() {
    return "I am alive";
  }
}
