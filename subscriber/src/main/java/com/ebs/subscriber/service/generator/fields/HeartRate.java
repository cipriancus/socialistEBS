package com.ebs.subscriber.service.generator.fields;

import java.util.concurrent.ThreadLocalRandom;

public class HeartRate implements Field{
    public static int min = 26;
    public static int max = 480;

    public String get(){
        return ""+ThreadLocalRandom.current().nextInt(min, max);
    }
}
