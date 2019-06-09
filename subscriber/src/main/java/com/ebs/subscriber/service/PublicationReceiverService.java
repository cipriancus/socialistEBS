package com.ebs.subscriber.service;

import com.ebs.subscriber.model.pojo.Publication;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PublicationReceiverService {

    public static List<Publication> publications = new ArrayList<>();
    public void processPublication(Publication publication){

        System.out.println("Received: "+publication.toString());

        LocalDateTime localDateTime = LocalDateTime.now(Clock.systemUTC());
        long miliseconds = LocalDateTime.parse(publication.getTimestamp()).until(localDateTime, ChronoUnit.MILLIS);
//        miliseconds = Math.abs(miliseconds); in case we still have negative times
        System.out.println("Duration: "+ miliseconds +" miliseconds");

        publication.setDifference(miliseconds);
        publications.add(publication);

    }

    public static List<Publication> getPublications() {
        return publications;
    }
}
