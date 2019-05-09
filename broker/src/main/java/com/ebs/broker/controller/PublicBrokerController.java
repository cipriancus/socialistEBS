package com.ebs.broker.controller;

import com.ebs.broker.model.Person;
import com.ebs.broker.model.Subscription;
import com.ebs.broker.service.PublicationService;
import com.ebs.broker.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/** Used to communicate with publishers and subscribers */
@RestController("/public")
public class PublicBrokerController {
  @Autowired private SubscriptionService subscriptionService;
  @Autowired private PublicationService publicationService;

  @PostMapping("/subscribe")
  public boolean subscribe(Subscription subscription) {
    return subscriptionService.subscribe(subscription);
  }

  @PostMapping("/publish")
  public boolean publish(List<Person> person) {
    return publicationService.publish(person);
  }
}
