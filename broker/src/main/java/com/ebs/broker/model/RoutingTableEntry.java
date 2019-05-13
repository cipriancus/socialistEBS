package com.ebs.broker.model;

public class RoutingTableEntry {
  private Subscription subscription;
  private String brokerIp;

  public RoutingTableEntry(Subscription subscription, String brokerIp) {
    this.subscription = subscription;
    this.brokerIp = brokerIp;
  }

  public Subscription getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

  public String getBrokerIp() {
    return brokerIp;
  }

  public void setBrokerIp(String brokerIp) {
    this.brokerIp = brokerIp;
  }
}
