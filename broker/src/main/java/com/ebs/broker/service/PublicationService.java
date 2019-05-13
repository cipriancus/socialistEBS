package com.ebs.broker.service;

import com.ebs.broker.model.Publication;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
  @Autowired
  BrokerCommunication brokerCommunication;

  public boolean publish(List<Publication> publications) {
    return brokerCommunication.handlePublication(publications,null);
  }
}
