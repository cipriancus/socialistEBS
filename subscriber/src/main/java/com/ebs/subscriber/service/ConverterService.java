package com.ebs.subscriber.service;

import com.ebs.subscriber.model.pojo.Publication;
import com.ebs.subscriber.model.pojo.Subscription;
import com.ebs.subscriber.model.pojo.SubscriptionProperty;
import com.ebs.subscriber.model.protogen.Pub;
import com.ebs.subscriber.model.protogen.Sub;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ConverterService {

    public static Publication getPublicationFromProtoString(String serialized) {
        Publication publication = null;
        try {
            Pub.Publication pub = Pub.Publication.parseFrom(serialized.getBytes());
            publication = new Publication(pub.getPatientName(), pub.getDateOfBirth(), pub.getHeight(), pub.getEyeColor(), pub.getHeartRate());
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println("Duration: "+ LocalDateTime.parse(pub.getTimestamp()).until(localDateTime, ChronoUnit.MILLIS)+" miliseconds");
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return publication;
    }

    public static String getProtoStringFromPublication(Publication publication) {
        Pub.Publication.Builder pubBuilder = Pub.Publication.newBuilder();
        pubBuilder.setDateOfBirth(publication.getDateOfBirth());
        pubBuilder.setEyeColor(publication.getEyeColor());
        pubBuilder.setHeartRate(publication.getHeartRate());
        pubBuilder.setPatientName(publication.getPatientName());
        pubBuilder.setHeight(publication.getHeight());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            pubBuilder.build().writeTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String publcationAsString = new String(outputStream.toByteArray());
        return publcationAsString;
    }

    public static String getProtoStringFromSubscription(Subscription subscription) {
        Sub.Subscription.Builder builder = Sub.Subscription.newBuilder();
        Sub.SubscriptionProperty.Builder propertyBuilder = Sub.SubscriptionProperty.newBuilder();
        for (SubscriptionProperty property : subscription.getProperties()) {
            propertyBuilder.setFieldName(property.getProperty());
            propertyBuilder.setOperator(property.getComparisonSign());
            propertyBuilder.setFieldValue(property.getValue());
            builder.addProperty(propertyBuilder.build());
        }
        Sub.Subscription protoSubscription = builder.build();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            protoSubscription.writeTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String subscriptionAsString = new String(outputStream.toByteArray());
        return subscriptionAsString;
    }

    public static Subscription getSubscriptionFromProtoString(String subscriptionAsProtoString) {
        Subscription subscription = new Subscription();
        try {
            Sub.Subscription protoSubscription = Sub.Subscription.parseFrom(subscriptionAsProtoString.getBytes());
            for (Sub.SubscriptionProperty protoProperty : protoSubscription.getPropertyList()) {
                SubscriptionProperty property = new SubscriptionProperty();
                property.setValue(protoProperty.getFieldValue());
                property.setComparisonSign(protoProperty.getOperator());
                property.setProperty(protoProperty.getFieldName());
                subscription.add(property);
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return subscription;
    }
}
