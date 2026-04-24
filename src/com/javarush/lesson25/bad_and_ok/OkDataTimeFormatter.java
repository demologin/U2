package com.javarush.lesson25.bad_and_ok;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OkDataTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM yyyy г. HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        String stingDataTime = now.format(dateTimeFormatter);

        System.out.println(stingDataTime);
        LocalDateTime localDateTime = LocalDateTime.parse("03/03 2022 г. 20.45.22", dateTimeFormatter);
        System.out.println(localDateTime);
    }
}
