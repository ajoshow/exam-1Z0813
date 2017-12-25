package com.ajoshow.exam1z0813;

/**
 * @author Andy on 2017/12/26.
 */

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class InstantTruncatedToMain {

    public static void main(String... args) {
        Instant i = Instant.now();
        System.out.println(i);

        for (ChronoUnit chronoUnit : ChronoUnit.values()) {
            try {
                Instant i2 = i.truncatedTo(chronoUnit);
                System.out.printf("%10s > %s%n", chronoUnit, i2);
            } catch (UnsupportedTemporalTypeException e) {
                System.out.printf("--%s not supported.%n", chronoUnit);
            }
        }


    }
}
