package com.javarush.lesson25.calc;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class DateTimeCalculator {
    public static void main(String[] args) {
        //how can I get current date
        Scanner scanner = new Scanner("""
                2025 02 21
                20 54 21
                +3""");

        int currentYear = scanner.nextInt();
        int currentMonth = scanner.nextInt();
        int currentDay = scanner.nextInt();
        int currentHour = scanner.nextInt();
        int currentMin = scanner.nextInt();
        int currentSecond = scanner.nextInt();
        int gmt = scanner.nextInt();

        long secondInMin = 60;
        long secondInHour = 60 * secondInMin;
        long secondsInDay = 24 * secondInHour;
        long secondsInStandartYear = 365 * secondsInDay;
        int[] days = {
                31, 28, 31, 30, 31, 30, 31,
                31, 30, 31, 30, 31,
        };

        long unixTime = 0;
        int direct = currentYear >= 1970 ? 1 : -1;
        for (int year = 1970; year != currentYear; year=year+direct) {
            unixTime += secondsInStandartYear*direct; //add years
            if (leapYear(year)) {
                unixTime += secondsInDay*direct;
            }
        }
        for (int month = 1; month < currentMonth; month++) {
            unixTime += days[month - 1] * secondsInDay; //add months
        }
        if (leapYear(currentYear) && currentMonth > 2) { //feb fix
            unixTime += secondsInDay;
        }
        unixTime += (currentDay - 1) * secondsInDay;
        unixTime += currentHour * secondInHour;
        unixTime += currentMin * secondInMin;
        unixTime += currentSecond;
        unixTime -= gmt * secondInHour;
        long javaTime = unixTime * 1000;
        Date date = new Date(javaTime);
        System.out.println(date + " " + date.getTime());
        System.out.println(ZonedDateTime.now());
    }

    private static boolean leapYear(int year) {
        return year % 400 == 0
               || (year % 4 == 0 && year % 100 != 0);
    }
}
