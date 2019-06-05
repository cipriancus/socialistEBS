package com.ebs.subscriber.model.pojo;

import java.util.Objects;

public class Publication {

    String patientName;
    String dateOfBirth;
    String height;
    String eyeColor;
    String heartRate;

    public Publication(String patientName, String dateOfBirth, String height, String eyeColor, String heartRate) {
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.eyeColor = eyeColor;
        this.heartRate = heartRate;
    }

    @Override
    public String toString() {
        return ("{(patient-name,\""+patientName+"\");" +
                "(DoB,\""+dateOfBirth+"\");" +
                "(height,"+height+");" +
                "(eye-color,\""+eyeColor+"\");" +
                "(heart-rate,"+heartRate+")}");
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getHeight() {
        return height;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHeartRate() {
        return heartRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return patientName.equals(that.patientName) &&
                dateOfBirth.equals(that.dateOfBirth) &&
                height.equals(that.height) &&
                eyeColor.equals(that.eyeColor) &&
                heartRate.equals(that.heartRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientName, dateOfBirth, height, eyeColor, heartRate);
    }
}
