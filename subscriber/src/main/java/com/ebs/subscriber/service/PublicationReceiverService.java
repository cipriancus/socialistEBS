package com.ebs.subscriber.service;

import com.ebs.subscriber.model.pojo.Publication;
import com.ebs.subscriber.model.protogen.Pub;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PublicationReceiverService {

    public static List<Publication> publications = new ArrayList<>();
    public void processPublication(Publication publication){
        publications.add(publication);

        System.out.println("Received: "+publication.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Duration: "+ LocalDateTime.parse(publication.getTimestamp()).until(localDateTime, ChronoUnit.MILLIS)+" miliseconds");

    }

    public static List<Publication> getPublications() {
        return publications;
    }
}
