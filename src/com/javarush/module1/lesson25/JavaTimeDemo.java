package com.javarush.module1.lesson25;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class JavaTimeDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String input = "2026-04-24T20:36:32.363715";
        LocalDateTime localDateTime = LocalDateTime.parse(input.trim());
        System.out.println(localDateTime);

        LocalDateTime newYearStart = LocalDateTime.of(2026, Month.JANUARY, 1, 0, 0, 0);
        LocalDateTime programmersDay = newYearStart.plusDays((1 << 8) - 1);
        LocalDate localDate = LocalDate.from(programmersDay);
        System.out.println(localDate);

        Instant instant0 = Instant.now();
        System.out.println("current instant0 UTC0: " + instant0);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime=" + zonedDateTime);

        Instant instant2 = Instant.from(zonedDateTime);
        System.out.println("current instant2 UTC0: " + instant0);

        long dayNumber = ChronoUnit.DAYS.between(newYearStart, LocalDateTime.now());
        long programmersDayAfter = ChronoUnit.DAYS.between(LocalDateTime.now(),programmersDay);
        System.out.println("dayNumber=" + dayNumber);
        System.out.println("programmersDayAfter=" + programmersDayAfter);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", Locale.of("ru"));
        String formatProgrammersDay = dateTimeFormatter.format(programmersDay);
        System.out.println("formatProgrammersDay=" + formatProgrammersDay);
        TemporalAccessor parse = dateTimeFormatter.parse(formatProgrammersDay);
        LocalDate localDate1 = LocalDate.from(parse);
        System.out.println("parse=" + localDate1);

    }
}
