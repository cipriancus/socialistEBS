package com.ebs.publisher.service.fields;

import java.util.Random;

public class PatientName implements Field{

    private static String[] names = {"Bob","Henry","George","Michael","Elena", "Carolina", "Katherine"};

    public String get(){
        return names[new Random().nextInt(names.length)];
    }

    public static String[] names(){

        return names;
    }
}
