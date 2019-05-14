package com.ebs.publisher.service.fields;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Height implements Field {
    public static double min = 1.20;
    public static double max = 2.1;

    public String get(){
        double value = (ThreadLocalRandom.current().nextDouble(min, max));
        return ""+BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }


}
