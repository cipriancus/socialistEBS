package fields;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class DateOfBirth implements Field{

    public static LocalDate min = LocalDate.parse("1900-01-01");
    public static LocalDate max = LocalDate.parse("2010-12-31");


    public String get(){
        long days = ChronoUnit.DAYS.between(min, max);
        LocalDate randomDate = min.plusDays(new Random().nextInt((int) days + 1));
        return randomDate.toString();
    }
}
