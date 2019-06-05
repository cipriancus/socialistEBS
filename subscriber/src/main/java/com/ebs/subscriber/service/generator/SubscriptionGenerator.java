package com.ebs.subscriber.service.generator;

import com.ebs.subscriber.model.pojo.Subscription;
import com.ebs.subscriber.model.pojo.SubscriptionProperty;
import com.ebs.subscriber.service.generator.fields.FieldFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SubscriptionGenerator {

    private int subscriptionsIterator = 0;
    private int patientNamePercentage;
    private int dateOfBirthPercentage;
    private int heightPercentage;
    private int eyeColorPercentage;
    private int heartRatePercentage;

    private int patientNameEqualityPercentage;
    private int dateOfBirthEqualityPercentage;
    private int heightEqualityPercentage;
    private int eyeColorEqualityPercentage;
    private int heartRateEqualityPercentage;


    public ArrayList<Subscription> generate(int count) {
        ArrayList<Subscription> subscriptions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            subscriptions.add(new Subscription());
        }

        int patientNameCount = patientNamePercentage > 0 ? count * patientNamePercentage / 100 : 0;
        int dateOfBirthCount = dateOfBirthPercentage > 0 ? count * dateOfBirthPercentage / 100 : 0;
        int heightCount = heightPercentage > 0 ? count * heightPercentage / 100 : 0;
        int eyeColorCount = eyeColorPercentage > 0 ? count * eyeColorPercentage / 100 : 0;
        int heartRateCount = heartRatePercentage > 0 ? count * heartRatePercentage / 100 : 0;

        int patientNameEqualityCount = patientNameEqualityPercentage > 0 ? count * patientNameEqualityPercentage / 100 : 0;
        int dateOfBirthEqualityCount = dateOfBirthEqualityPercentage > 0 ? count * dateOfBirthEqualityPercentage / 100 : 0;
        int heightEqualityCount = heightEqualityPercentage > 0 ? count * heightEqualityPercentage / 100 : 0;
        int eyeColorEqualityCount = eyeColorEqualityPercentage > 0 ? count * eyeColorEqualityPercentage / 100 : 0;
        int heartRateEqualityCount = heartRateEqualityPercentage > 0 ? count * heartRateEqualityPercentage / 100 : 0;

        int subscriptionsIterator = 0;

        addPropertiesToSubscriptions(count, subscriptions, patientNameCount, patientNameEqualityCount, FieldFactory.PATIENT_NAME);
        addPropertiesToSubscriptions(count, subscriptions, dateOfBirthCount, dateOfBirthEqualityCount, FieldFactory.DATE_OF_BIRTH);
        addPropertiesToSubscriptions(count, subscriptions, heightCount, heightEqualityCount, FieldFactory.HEIGHT);
        addPropertiesToSubscriptions(count, subscriptions, eyeColorCount, eyeColorEqualityCount, FieldFactory.EYE_COLOR);
        addPropertiesToSubscriptions(count, subscriptions, heartRateCount, heartRateEqualityCount, FieldFactory.HEART_RATE);

        return subscriptions;
    }


    public void generate(int count, OutputStream outputStream) throws IOException {
        ArrayList<Subscription> subscriptions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            subscriptions.add(new Subscription());
        }

        int patientNameCount = patientNamePercentage > 0 ? count * patientNamePercentage / 100 : 0;
        int dateOfBirthCount = dateOfBirthPercentage > 0 ? count * dateOfBirthPercentage / 100 : 0;
        int heightCount = heightPercentage > 0 ? count * heightPercentage / 100 : 0;
        int eyeColorCount = eyeColorPercentage > 0 ? count * eyeColorPercentage / 100 : 0;
        int heartRateCount = heartRatePercentage > 0 ? count * heartRatePercentage / 100 : 0;

        int patientNameEqualityCount = patientNameEqualityPercentage > 0 ? count * patientNameEqualityPercentage / 100 : 0;
        int dateOfBirthEqualityCount = dateOfBirthEqualityPercentage > 0 ? count * dateOfBirthEqualityPercentage / 100 : 0;
        int heightEqualityCount = heightEqualityPercentage > 0 ? count * heightEqualityPercentage / 100 : 0;
        int eyeColorEqualityCount = eyeColorEqualityPercentage > 0 ? count * eyeColorEqualityPercentage / 100 : 0;
        int heartRateEqualityCount = heartRateEqualityPercentage > 0 ? count * heartRateEqualityPercentage / 100 : 0;

        int subscriptionsIterator = 0;

        addPropertiesToSubscriptions(count, subscriptions, patientNameCount, patientNameEqualityCount, FieldFactory.PATIENT_NAME);
        addPropertiesToSubscriptions(count, subscriptions, dateOfBirthCount, dateOfBirthEqualityCount, FieldFactory.DATE_OF_BIRTH);
        addPropertiesToSubscriptions(count, subscriptions, heightCount, heightEqualityCount, FieldFactory.HEIGHT);
        addPropertiesToSubscriptions(count, subscriptions, eyeColorCount, eyeColorEqualityCount, FieldFactory.EYE_COLOR);
        addPropertiesToSubscriptions(count, subscriptions, heartRateCount, heartRateEqualityCount, FieldFactory.HEART_RATE);


        for (Subscription subscription : subscriptions) {
            outputStream.write((subscription.toString() + "\n").getBytes());
        }

    }

    private void addPropertiesToSubscriptions(int count, ArrayList<Subscription> subscriptions, int propertyCount, int equalityCount, String propertyName) {
        for (int i = 0; i < propertyCount; i++) {

            SubscriptionProperty property = new SubscriptionProperty(propertyName, new FieldFactory().get(propertyName).get());
            if (i < equalityCount) {

                property.setComparisonSign("=");
            } else {

                property.setComparisonSign(SubscriptionProperty.ComparisonSignGenerator.generateComparisonSign());
            }

            subscriptions.get(subscriptionsIterator).add(property);
            subscriptionsIterator = subscriptionsIterator == count - 1 ? 0 : subscriptionsIterator + 1;
        }
    }


    public int getPatientNamePercentage() {
        return patientNamePercentage;
    }

    public void setPatientNamePercentage(int patientNamePercentage) {
        this.patientNamePercentage = patientNamePercentage;
    }

    public int getDateOfBirthPercentage() {
        return dateOfBirthPercentage;
    }

    public void setDateOfBirthPercentage(int dateOfBirthPercentage) {
        this.dateOfBirthPercentage = dateOfBirthPercentage;
    }

    public int getHeightPercentage() {
        return heightPercentage;
    }

    public void setHeightPercentage(int heightPercentage) {
        this.heightPercentage = heightPercentage;
    }

    public int getEyeColorPercentage() {
        return eyeColorPercentage;
    }

    public void setEyeColorPercentage(int eyeColorPercentage) {
        this.eyeColorPercentage = eyeColorPercentage;
    }

    public int getHeartRatePercentage() {
        return heartRatePercentage;
    }

    public void setHeartRatePercentage(int heartRatePercentage) {
        this.heartRatePercentage = heartRatePercentage;
    }

    public int getSubscriptionsIterator() {
        return subscriptionsIterator;
    }

    public void setSubscriptionsIterator(int subscriptionsIterator) {
        this.subscriptionsIterator = subscriptionsIterator;
    }

    public int getPatientNameEqualityPercentage() {
        return patientNameEqualityPercentage;
    }

    public void setPatientNameEqualityPercentage(int patientNameEqualityPercentage) {
        this.patientNameEqualityPercentage = patientNameEqualityPercentage;
    }

    public int getDateOfBirthEqualityPercentage() {
        return dateOfBirthEqualityPercentage;
    }

    public void setDateOfBirthEqualityPercentage(int dateOfBirthEqualityPercentage) {
        this.dateOfBirthEqualityPercentage = dateOfBirthEqualityPercentage;
    }

    public int getHeightEqualityPercentage() {
        return heightEqualityPercentage;
    }

    public void setHeightEqualityPercentage(int heightEqualityPercentage) {
        this.heightEqualityPercentage = heightEqualityPercentage;
    }

    public int getEyeColorEqualityPercentage() {
        return eyeColorEqualityPercentage;
    }

    public void setEyeColorEqualityPercentage(int eyeColorEqualityPercentage) {
        this.eyeColorEqualityPercentage = eyeColorEqualityPercentage;
    }

    public int getHeartRateEqualityPercentage() {
        return heartRateEqualityPercentage;
    }

    public void setHeartRateEqualityPercentage(int heartRateEqualityPercentage) {
        this.heartRateEqualityPercentage = heartRateEqualityPercentage;
    }
}
