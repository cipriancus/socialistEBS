package com.ebs.broker.model;

import com.ebs.broker.model.pojo.Publication;
import com.ebs.broker.model.protobuf.Pub;
import com.google.protobuf.InvalidProtocolBufferException;

public class ConverterService {

    public static Publication getPublicationFromProtoStrong(String serialized){
        Publication publication = null;
        try {
            Pub.Publication pub = Pub.Publication.parseFrom(serialized.getBytes());
            publication = new Publication(pub.getPatientName(),pub.getDateOfBirth(),pub.getHeight(),pub.getEyeColor(),pub.getHeartRate());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return publication;
    }
}
