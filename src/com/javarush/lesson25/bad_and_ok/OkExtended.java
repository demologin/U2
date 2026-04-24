package com.javarush.lesson25.bad_and_ok;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class OkExtended {
    public static void main(String[] args) {
        ZonedDateTime t1 = ZonedDateTime.now();
        System.out.println(t1);

        OffsetDateTime t2 = OffsetDateTime.now();
        System.out.println(t2);

        LocalDateTime t3 = LocalDateTime.now();
        System.out.println(t3);

        Instant instant = t1.toInstant();
        System.out.println(instant);

        long miliseconds = instant.toEpochMilli();
        System.out.println(miliseconds);
        System.out.println("convertor to old Date class" + new Date(miliseconds));

    }
}
