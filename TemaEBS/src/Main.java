import generator.Publication;
import fields.*;
import generator.PublicationGenerator;
import generator.SubscriptionGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static FieldFactory fieldFactory = new FieldFactory();
    private static int pubNumber = 0;
    private static int subNumber = 0;
    private static int patientNamePercentage;
    private static int dateOfBirthPercentage;
    private static int heightPercentage;
    private static int eyeColorPercentage;
    private static int heartRatePercentage;
    //private static int EqualityPercentage;
    //private static String equalityFieldName;

    private static int patientNameEqualityPercentage;
    private static int dateOfBirthEqualityPercentage;
    private static int heightEqualityPercentage;
    private static int eyeColorEqualityPercentage;
    private static int heartRateEqualityPercentage;


    public static void main(String[] args) {

//        int pubNumber = Integer.parseInt(args[0]);

        File publications = new File("publications.txt");
        FileOutputStream publicationsOutputStream = null;
        try {
            publications.createNewFile();
            publicationsOutputStream = new FileOutputStream(publications);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File subscriptions = new File("subscriptions.txt");
        FileOutputStream subscriptionsOutputStream = null;
        try {
            subscriptions.createNewFile();
            subscriptionsOutputStream = new FileOutputStream(subscriptions);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getInputParamteresFromUser(args);

        if (patientNameEqualityPercentage + dateOfBirthEqualityPercentage + heightEqualityPercentage + eyeColorEqualityPercentage + heartRateEqualityPercentage < 100) {
            System.out.println("Percentages do not add up to 100%");
        } else {
            SubscriptionGenerator generator = new SubscriptionGenerator();
            generator.setPatientNamePercentage(patientNamePercentage);
            generator.setDateOfBirthPercentage(dateOfBirthPercentage);
            generator.setEyeColorPercentage(eyeColorPercentage);
            generator.setHeartRatePercentage(heartRatePercentage);
            generator.setHeightPercentage(heightPercentage);
            generator.setPatientNameEqualityPercentage(patientNameEqualityPercentage);
            generator.setDateOfBirthEqualityPercentage(dateOfBirthEqualityPercentage);
            generator.setHeightEqualityPercentage(heightEqualityPercentage);
            generator.setEyeColorEqualityPercentage(eyeColorEqualityPercentage);
            generator.setHeartRateEqualityPercentage(heartRateEqualityPercentage);
            if (subscriptionsOutputStream != null) {
                try {
                    generator.generate(subNumber, subscriptionsOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (publicationsOutputStream != null) {
                try {
                    new PublicationGenerator().generatePublications(pubNumber, publicationsOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            closeStream(subscriptionsOutputStream);
            closeStream(publicationsOutputStream);
        }
    }

    private static void closeStream(FileOutputStream stream) {
        try {
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getInputParamteresFromUser(String[] args) {

        String hint = "[number of publications][number of subscriptions][pacient-name %][date-of-birth %][height %][eye-color %][heart-rate %]" +
                "[pacient-name = %][date-of-birth = %][height = %][eye-color = %][heart-rate = %]";

        pubNumber = Integer.valueOf(args[0]);
        subNumber = Integer.valueOf(args[1]);

        patientNamePercentage = Integer.valueOf(args[2]);
        dateOfBirthPercentage = Integer.valueOf(args[3]);
        heightPercentage = Integer.valueOf(args[4]);
        eyeColorPercentage = Integer.valueOf(args[5]);
        heartRatePercentage = Integer.valueOf(args[6]);

        patientNameEqualityPercentage = Integer.valueOf(args[7]);
        dateOfBirthEqualityPercentage = Integer.valueOf(args[8]);
        heightEqualityPercentage = Integer.valueOf(args[9]);
        eyeColorEqualityPercentage = Integer.valueOf(args[10]);
        heartRateEqualityPercentage = Integer.valueOf(args[11]);

        if (patientNamePercentage < patientNameEqualityPercentage) {

            System.out.println("The percentage of equality frequency for \"patient-name\" is greater than the total percentage of it. ");
            System.out.println("It will be automatically changed to: "+patientNamePercentage);
            patientNameEqualityPercentage = patientNamePercentage;
        }

        if (dateOfBirthPercentage < dateOfBirthEqualityPercentage) {

            System.out.println("The percentage of equality frequency for \"DoB\" is greater than the total percentage of it. ");
            System.out.println("It will be automatically changed to: "+dateOfBirthPercentage);
            dateOfBirthEqualityPercentage = dateOfBirthPercentage;
        }

        if (heightPercentage < heightEqualityPercentage) {

            System.out.println("The percentage of equality frequency for \"height\" is greater than the total percentage of it. ");
            System.out.println("It will be automatically changed to: "+heightPercentage);
            heightEqualityPercentage = heightPercentage;
        }

        if (eyeColorPercentage < eyeColorEqualityPercentage) {

            System.out.println("The percentage of equality frequency for \"eye-color\" is greater than the total percentage of it. ");
            System.out.println("It will be automatically changed to: "+eyeColorPercentage);
            eyeColorEqualityPercentage = eyeColorPercentage;
        }

        if (heartRatePercentage < heartRateEqualityPercentage) {

            System.out.println("The percentage of equality frequency for \"heart-rate\" is greater than the total percentage of it. ");
            System.out.println("It will be automatically changed to: "+heartRatePercentage);
            heartRateEqualityPercentage = heartRatePercentage;
        }
    }
}
