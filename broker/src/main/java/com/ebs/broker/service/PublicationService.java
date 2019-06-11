package com.ebs.broker.service;

import com.ebs.broker.model.pojo.Publication;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {
  @Autowired BrokerCommunication brokerCommunication;

  public boolean handleNotification(Publication publication, String clientIp) {
    System.out.println("Received publication: " + publication.toString() + " from " + clientIp);
    return brokerCommunication.handleNotification(publication, clientIp);
  }
}
