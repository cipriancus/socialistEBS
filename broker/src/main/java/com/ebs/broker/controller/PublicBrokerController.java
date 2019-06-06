package com.ebs.broker.controller;

import com.ebs.broker.model.ConverterService;
import com.ebs.broker.model.pojo.Subscription;
import com.ebs.broker.service.PublicationService;
import com.ebs.broker.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Used to communicate with publishers and subscribers */
@RestController()
@RequestMapping("/public")
public class PublicBrokerController {
  @Autowired private SubscriptionService subscriptionService;
  @Autowired private PublicationService publicationService;

  /**
   * A subscriber can subscribe to a broker with a subscription object and it will propagate in
   * network via identity routing
   *
   * @param subscription
   * @return
   */
  @PostMapping("/subscribe")
  public boolean subscribe(
      @RequestBody String subscription, @RequestHeader("client_ip") String clientIp) {
    return subscriptionService.subscribe(
        ConverterService.getSubscriptionFromProtoString(subscription), clientIp);
  }

  /**
   * Publish a person and the broker will propagate in the network via identity routing
   *
   * @param publication
   * @return
   */
  @PostMapping("/publish")
  public boolean publish(
      @RequestBody String publication, @RequestHeader("client_ip") String clientIp) {
    return publicationService.handleNotification(
        ConverterService.getPublicationFromProtoString(publication), clientIp);
  }
}
