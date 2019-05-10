package com.ebs.broker.service;

import com.ebs.broker.model.Person;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
  @Autowired
  BrokerCommunication brokerCommunication;

  public boolean publish(List<Person> persons) {
    return brokerCommunication.handlePublication(persons);
  }
}
