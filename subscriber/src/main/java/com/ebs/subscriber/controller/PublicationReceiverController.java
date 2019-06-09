package com.ebs.subscriber.controller;

import com.ebs.subscriber.model.pojo.Publication;
import com.ebs.subscriber.service.ConverterService;
import com.ebs.subscriber.service.PublicationReceiverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController()
public class PublicationReceiverController {
    private PublicationReceiverService service = new PublicationReceiverService();

    @PostMapping("/publication")
    public void receivePublication(@RequestBody String publication){
        Publication pub = ConverterService.getPublicationFromProtoString(publication);
        System.out.println("Received publication at: "+LocalDateTime.now(Clock.systemUTC()).toString()+" sent at: "+pub.getTimestamp());
        service.processPublication(pub);
    }

    @GetMapping("/getReport")
    public String getReport(){
        if(PublicationReceiverService.getPublications().size()==0){
            return "No publications received";
        }
        long milis = 0;
        for (Publication pub: PublicationReceiverService.getPublications()) {
            milis+=pub.getDifference();
        }
        milis = milis/ PublicationReceiverService.getPublications().size();
        StringBuilder builder = new StringBuilder("Mean time of received publication calculated by this subscriber is: " + milis+" miliseconds\n");
        builder.append("\n Total received publications: "+PublicationReceiverService.getPublications().size());
        return builder.toString();
    }
}
