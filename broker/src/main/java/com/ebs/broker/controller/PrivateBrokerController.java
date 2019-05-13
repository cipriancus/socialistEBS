package com.ebs.broker.controller;

import com.ebs.broker.model.Publication;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Used to communicate with other brokers */
@RestController()
@RequestMapping("/private")
public class PrivateBrokerController {
  @Autowired private BrokerCommunication brokerCommunication;

  /**
   * When you join the network you have to provide your IP:port so nodes can contact you
   *
   * @param ipAddress
   * @return
   */
  @PostMapping("join_network")
  public boolean joinNetwork(String ipAddress) {
    return brokerCommunication.joinNetwork(ipAddress);
  }

  /**
   * If a publication is send via public api in PublicBrokerController publicate, the receiving
   * broker will propagate it in the network via this private endpoint and this will trigger the
   * identity routing to send it to all the subscribers that match the subscriptions each broker has
   *
   * @param publicationList the list of publication
   * @param brokerIp the SOURCE ip of the message ( for identification purposes, ease of impl )
   * @return bool, depending on the success of the operation or not
   */
  @PostMapping("propagate_publication")
  public boolean propagatePublication(List<Publication> publicationList, String brokerIp) {
    return brokerCommunication.handlePublication(publicationList, brokerIp);
  }

  /**
   * Other nodes can ping a node
   *
   * @return
   */
  @GetMapping("ping")
  public String ping() {
    return "I am alive";
  }
}
