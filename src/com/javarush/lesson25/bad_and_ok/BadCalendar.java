package com.javarush.lesson25.bad_and_ok;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class BadCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970,Calendar.JANUARY,1,3,0,0);
        long timeInMillis = calendar.getTimeInMillis();
        Date time = calendar.getTime();

        System.out.println(timeInMillis);
        System.out.println(calendar.getTimeZone());

        TimeZone timeZone = TimeZone.getTimeZone("GMТ+0");
        calendar.setTimeZone(timeZone);
        calendar.set(1970,Calendar.JANUARY,1,0,0);
        long timeInMillisGMT0 = calendar.getTimeInMillis();
        System.out.println(timeInMillisGMT0);
        System.out.println(calendar.getTimeZone());

        calendar.set(1970,Calendar.JANUARY,1,0,0,1);
        long timeInMillisGMT0_1 = calendar.getTimeInMillis();
        System.out.println(timeInMillisGMT0_1-timeInMillisGMT0);
    }
}
