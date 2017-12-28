package com.ajoshow.exam1z0813;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DaylightSavingMain {

    public static void main(String[] args) {

        // ld1 and ld2 has -1 hour in difference (ld2 is before ld1),
        // since zd1 has 1 hour daylight saving in US/Eastern, which means it has additional hour (2AM->1AM, 3AM->2AM)
        // so think if ld1 is 2015-11-1T02:00, zd1 must be 2015-11-1T03:00 in order to be the same as ld1. (3AM -> 2AM)
        // thus, zd1 and zd2 should have -2 hour in difference.

        // Given that daylight Savings Time ends on Nov 1 at 2 AM in US/Eastern time zone. (As a result, 2 AM becomes 1 AM.)
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
        System.out.println("ld1: " + ld1);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));
        System.out.println("zd1: " + zd1);
        LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
        System.out.println("ld2: " + ld2);
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        System.out.println("zd2: " + zd2);
        long x = ChronoUnit.HOURS.between(zd1, zd2);
        System.out.println(x); // -2
    }
}
