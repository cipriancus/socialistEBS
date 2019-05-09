package com.ebs.broker.service;

import com.ebs.broker.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {
  public boolean publish(List<Person> person){
      return true;
  }
}
