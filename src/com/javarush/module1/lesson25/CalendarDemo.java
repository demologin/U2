package com.javarush.module1.lesson25;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, Calendar.JANUARY, 1, 3, 0, 0);
        Date time0 = calendar.getTime();
        System.out.println(time0);
        System.out.println(time0.getTime());

        calendar.set(1970, Calendar.JANUARY, 1, 3, 0, 1);
        Date time1 = calendar.getTime();
        System.out.println(time1);
        System.out.println(time1.getTime());
        Locale ru = Locale.of("ru");

        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", ru);
        String txtDateTime = dateFormat.format(calendar.getTime());
        System.out.println(txtDateTime);
        try {
            Date time = dateFormat.parse(txtDateTime);
            System.out.println(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
