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

        System.out.println("Received: "+publication.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        long miliseconds = LocalDateTime.parse(publication.getTimestamp()).until(localDateTime, ChronoUnit.MILLIS);
        miliseconds = Math.abs(miliseconds);
        System.out.println("Duration: "+ miliseconds +" miliseconds");

        publication.setDifference(miliseconds);
        publications.add(publication);

    }

    public static List<Publication> getPublications() {
        return publications;
    }
}
