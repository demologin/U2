package com.javarush.module1.lesson19.demoenum;

import java.util.Arrays;
import java.util.List;

public enum WeekDay {
    SUNDAY("вс"),
    MONDAY("пн"),
    TUESDAY("вт"),
    WEDNESDAY("ср"),
    THURSDAY("чт"),
    FRIDAY("пт"),
    SATURDAY("сб");

    private final String russianName;

    WeekDay(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    public String getEnglishName() {
        return name().toLowerCase();
    }


    @Override
    public String toString() {
        return ordinal() + ". " + name() + " {" +
               this.getRussianName() + ", " +
               this.getEnglishName()
               + "}";
    }

    public static List<WeekDay> getAsList() {
        return Arrays.asList(WeekDay.values());
    }
}
