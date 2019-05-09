package com.ebs.broker.service;

import com.ebs.broker.model.Subscription;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    public boolean subscribe(Subscription subscription){
        return true;
    }
}
