package com.ebs.broker.controller;

import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Used to communicate with other brokers */
@RestController()
@RequestMapping("/private")
public class PrivateBrokerController {
  @Autowired private BrokerCommunication brokerCommunication;

  @PostMapping("join_network")
  public boolean joinNetwork(String ipAddress) {
    return brokerCommunication.joinNetwork(ipAddress);
  }

  @GetMapping("ping")
  public String ping() {
    return "I am alive";
  }
}
