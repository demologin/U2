package com.javarush.module1.lesson19.demoenum;

public class WeekDayClient {
    public static void main(String[] args) {
        WeekDay[] values = WeekDay.values();
        WeekDay weekDay = WeekDay.valueOf("FRIDAY");
        int index = weekDay.ordinal();
        System.out.println(index);
        WeekDay.getAsList().forEach(System.out::println);

        switch (weekDay) {
            case MONDAY:
                System.out.println("Very hard "+weekDay);
                break;
            case SUNDAY:
                System.out.println("Best " + weekDay);
                break;
            case SATURDAY:
                System.out.println("Cool " + weekDay);
                break;
            default:
                System.out.println("Work " + weekDay);
        }

    }
}
