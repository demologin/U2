package com.javarush.lesson25.bad_and_ok;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BadDateFormat {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        int[] formats = {DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT};
        for (int df : formats) {
            for (int tf : formats) {
                DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(df, tf);
                String strDateTime = dateFormat.format(date);
                System.out.println(strDateTime);
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String formattedDate = simpleDateFormat.format(date);
        System.out.println(formattedDate);
        Date date1 = simpleDateFormat.parse("20.10.2023 19:46:43");
        System.out.println(date1);


    }
}
