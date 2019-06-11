package com.ebs.broker.service;

import com.ebs.broker.model.pojo.Publication;
import com.ebs.broker.model.pojo.Subscription;
import com.ebs.broker.model.pojo.SubscriptionProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ComparerService {
  public static boolean compare(Subscription subscription, Publication publication) {
    for (SubscriptionProperty iterator : subscription.getProperties()) {
      if (iterator.getProperty().equals("patient-name")
              && !iterator.getValue().equals(publication.getPatientName())) {
        return false;
      } else if (iterator.getProperty().equals("DoB")) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (iterator.getValue() == null) {
          return false;
        }

        Calendar subscriptionCalendar = Calendar.getInstance();
        Calendar publicationCalendar = Calendar.getInstance();
        try {
          subscriptionCalendar.setTime(sdf.parse(iterator.getValue()));
          publicationCalendar.setTime(sdf.parse(publication.getDateOfBirth()));
        } catch (ParseException e) {
          return false;
        }

        if (iterator.getComparisonSign().equalsIgnoreCase("=")
                && !(subscriptionCalendar.equals(publicationCalendar))) {
          return false;
        } else if (iterator.getComparisonSign().equalsIgnoreCase("<>")
                && !(!subscriptionCalendar.equals(publicationCalendar))) {
          return false;
        } else if (iterator.getComparisonSign().equalsIgnoreCase("<=")
                && !(publicationCalendar.before(subscriptionCalendar)
                || publicationCalendar.equals(subscriptionCalendar))) {
          return false;
        } else if (iterator.getComparisonSign().equalsIgnoreCase("<")
                && !(publicationCalendar.before(subscriptionCalendar))) {
          return false;
        } else if (iterator.getComparisonSign().equalsIgnoreCase(">")
                && !(publicationCalendar.after(subscriptionCalendar))) {
          return false;
        } else if (iterator.getComparisonSign().equalsIgnoreCase(">=")
                && !(publicationCalendar.after(subscriptionCalendar)
                || publicationCalendar.equals(subscriptionCalendar))) {
          return false;
        }
      } else if (iterator.getProperty().equals("height")) {
        Double height = Double.parseDouble(iterator.getValue());
        if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase("=")
                && !(height == Double.parseDouble(publication.getHeight()))) {
          return false;
        } else if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<>")
                && !(height != Double.parseDouble(publication.getHeight()))) {
          return false;
        } else if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<=")
                && !(Double.parseDouble(publication.getHeight()) <= height)) {
          return false;
        } else if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<")
                && !(Double.parseDouble(publication.getHeight()) < height)) {
          return false;
        } else if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase(">")
                && !(Double.parseDouble(publication.getHeight()) > height)) {
          return false;
        } else if (height > 0
                && iterator.getComparisonSign().equalsIgnoreCase(">=")
                && !(Double.parseDouble(publication.getHeight()) >= height)) {
          return false;
        }
      } else if (iterator.getProperty().equals("eye-color")
              && !iterator.getValue().equals(publication.getEyeColor())) {
        return false;
      } else if (iterator.getProperty().equals("heart-rate")) {
        Double heartRate = Double.parseDouble(iterator.getValue());
        if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase("=")
                && !(heartRate == Double.parseDouble(publication.getHeartRate()))) {
          return false;
        } else if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<>")
                && !(heartRate != Double.parseDouble(publication.getHeartRate()))) {
          return false;
        } else if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<=")
                && !(Double.parseDouble(publication.getHeartRate()) <= heartRate)) {
          return false;
        } else if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase("<")
                && !(Double.parseDouble(publication.getHeartRate()) < heartRate)) {
          return false;
        } else if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase(">")
                && !(Double.parseDouble(publication.getHeartRate()) > heartRate)) {
          return false;
        } else if (heartRate > 0
                && iterator.getComparisonSign().equalsIgnoreCase(">=")
                && !(Double.parseDouble(publication.getHeartRate()) >= heartRate)) {
          return false;
        }
      }
    }
    return true;
  }
}
