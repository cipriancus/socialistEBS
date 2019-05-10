package com.ebs.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.ebs.broker.*")
public class BrokerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BrokerApplication.class, args);
  }
}
