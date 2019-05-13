package com.ebs.broker.controller;

import com.ebs.broker.model.Publication;
import com.ebs.broker.model.Subscription;
import com.ebs.broker.service.PublicationService;
import com.ebs.broker.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
  public boolean subscribe(Subscription subscription) {
    return subscriptionService.subscribe(subscription);
  }

  /**
   * Publish a list o persons and the broker will propagate in the network via identity routing
   *
   * @param publications
   * @return
   */
  @PostMapping("/publish")
  public boolean publish(List<Publication> publications) {
    return publicationService.publish(publications);
  }
}
