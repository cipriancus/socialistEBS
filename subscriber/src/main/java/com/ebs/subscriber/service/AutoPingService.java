package com.ebs.subscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class AutoPingService {

    @Value("${myIp}")
    private String myBroker;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0/60 * * * * *")
    public void pingKnownBrokers() {
        try {
            restTemplate.getForEntity("https://" + myBroker + "/getReport", String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
