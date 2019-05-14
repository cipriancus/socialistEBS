package com.ebs.publisher.service.fields;

import java.util.Random;

public class EyeColor implements Field {
    private static String[] colors = {"blue","black","brown","green","gray","ce facem daca culoare ochilor este diferita"};

    public String get(){
        return colors[new Random().nextInt(colors.length)];
    }

    public static String[] colors(){

        return colors;
    }
}
