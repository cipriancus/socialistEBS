package com.ebs.broker.controller;

import com.ebs.broker.model.ConverterService;
import com.ebs.broker.model.pojo.Subscription;
import com.ebs.broker.network.BrokerCommunication;
import com.ebs.broker.service.PublicationService;
import com.ebs.broker.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Used to communicate with other brokers */
@RestController()
@RequestMapping("/private")
public class PrivateBrokerController {
  @Autowired private BrokerCommunication brokerCommunication;
  @Autowired private SubscriptionService subscriptionService;
  @Autowired private PublicationService publicationService;

  /**
   * When you join the network you have to provide your IP:port so nodes can contact you
   *
   * @param ipAddress
   * @return
   */
  @PostMapping("join_network")
  public boolean joinNetwork(@RequestBody String ipAddress) {
    return brokerCommunication.joinNetwork(ipAddress);
  }

  /**
   * If a publication is send via public api in PublicBrokerController publicate, the receiving
   * broker will propagate it in the network via this private endpoint and this will trigger the
   * identity routing to send it to all the subscribers that match the subscriptions each broker has
   *
   * @param publication a publication
   * @param brokerIp the SOURCE ip of the message ( for identification purposes, ease of impl )
   * @return bool, depending on the success of the operation or not
   */
  @PostMapping("propagate_publication")
  public boolean propagatePublication(
      @RequestBody String publication, @RequestHeader("broker_ip") String brokerIp) {
    return publicationService.handleNotification(ConverterService.getPublicationFromProtoString(publication), brokerIp);
  }

  /**
   * @param subscription a subscription
   * @param brokerIp the SOURCE ip of the message ( for identification purposes, ease of impl )
   * @return bool, depending on the success of the operation or not
   */
  @PostMapping("propagate_subscription")
  public boolean propagateSubscription(
      @RequestBody String subscription, @RequestHeader("broker_ip") String brokerIp) {
    return subscriptionService.subscribe(ConverterService.getSubscriptionFromProtoString(subscription), brokerIp);
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
