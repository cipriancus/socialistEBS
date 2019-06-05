package com.ebs.subscriber.controller;

import com.ebs.subscriber.service.ConverterService;
import com.ebs.subscriber.service.PublicationReceiverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PublicationReceiverController {
    PublicationReceiverService service = new PublicationReceiverService();

    @PostMapping("/publication")
    public void receivePublication(@RequestBody String publication){
        service.processPublication(ConverterService.getPublicationFromProtoString(publication));
    }
}
