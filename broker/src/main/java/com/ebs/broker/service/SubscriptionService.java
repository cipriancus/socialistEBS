package com.ebs.broker.service;

import com.ebs.broker.model.Subscription;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
  @Autowired
  BrokerCommunication brokerCommunication;

  public boolean subscribe(Subscription subscription) {
    return brokerCommunication.handleSubscription(subscription);
  }
}
