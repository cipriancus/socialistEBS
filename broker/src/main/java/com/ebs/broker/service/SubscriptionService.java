package com.ebs.broker.service;

import com.ebs.broker.model.pojo.Subscription;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubscriptionService {
  @Autowired BrokerCommunication brokerCommunication;

  public boolean subscribe(Subscription subscription, String clientIp) {
    System.out.println("Received subscription: "+subscription.toString()+" from "+clientIp);
    Set<Subscription> subscriptionSet = brokerCommunication.administer(subscription, clientIp);
    return brokerCommunication.handleAdminMessage(subscriptionSet, clientIp);
  }
}
