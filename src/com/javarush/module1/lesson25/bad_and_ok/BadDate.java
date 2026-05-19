package com.javarush.module1.lesson25.bad_and_ok;

import java.util.Calendar;
import java.util.Date;

public class BadDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.MARCH, 3,19,36,10);
        Date date = calendar.getTime();
        long t1=date.getTime();
        System.out.println(date);

        calendar.set(2022, Calendar.MARCH, 3,19,36,11);
        long t2=calendar.getTimeInMillis();

        System.out.println(t2-t1);
    }
}
