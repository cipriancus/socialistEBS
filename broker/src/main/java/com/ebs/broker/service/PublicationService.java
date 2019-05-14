package com.ebs.broker.service;

import com.ebs.broker.model.protobuf.Publication;
import com.ebs.broker.network.BrokerCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
  @Autowired BrokerCommunication brokerCommunication;

  public boolean handleNotification(Publication publications, String clientIp) {
    return brokerCommunication.handleNotification(publications, clientIp);
  }
}
