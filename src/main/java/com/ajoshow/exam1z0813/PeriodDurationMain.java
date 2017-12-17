package com.ajoshow.exam1z0813;

import java.time.*;

public class PeriodDurationMain {

    public static void main(String[] args) {

        Period p = Period.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println(p);
        Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 1, 0, 0, 0));
        System.out.println(d);
        // this line throws java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
//        d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
//        System.out.println(d);

        // ofXXX is a static method, the instance is irrelevant, thus p2 is P1D
        Period p2 = Period.ofMonths(1).ofDays(1);
        System.out.println(p2);
    }


}
