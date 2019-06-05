package com.ebs.subscriber.service;

import com.ebs.subscriber.model.pojo.Publication;

public class PublicationReceiverService {

    public void processPublication(Publication publication){
        System.out.println("Received: "+publication.toString());
    }
}
