package com.ebs.subscriber.controller;

import com.ebs.subscriber.model.pojo.Publication;
import com.ebs.subscriber.service.ConverterService;
import com.ebs.subscriber.service.PublicationReceiverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController()
public class PublicationReceiverController {
    private PublicationReceiverService service = new PublicationReceiverService();

    @PostMapping("/publication")
    public void receivePublication(@RequestBody String publication){
        service.processPublication(ConverterService.getPublicationFromProtoString(publication));
    }

    @GetMapping("/getReport")
    public String getReport(){
        long milis = 0;
        for (Publication pub: PublicationReceiverService.getPublications()) {
            LocalDateTime localDateTime = LocalDateTime.now();
            milis+=LocalDateTime.parse(pub.getTimestamp()).until(localDateTime, ChronoUnit.MILLIS);
        }
        milis = milis/ PublicationReceiverService.getPublications().size();
        return "Mean time of received publication calculated by this broker is: " + milis;
    }
}
