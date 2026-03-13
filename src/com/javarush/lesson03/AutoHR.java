package com.javarush.lesson03;

import java.util.Scanner;

public class AutoHR {

    public static final int MIN_AGE = 18;
    public static final int MAX_AGE_JUNIOR = 40;
    public static final int MIN_EXP_JUNIOR = 0;
    public static final int MAX_EXP_JUNIOR = 1;
    public static final int MIN_SALARY_JUNIOR = 500;
    public static final int MAX_SALARY_JUNIOR = 1000;
    public static final int MIN_AGE_SENIOR = 25;
    public static final int MAX_AGE = 60;
    public static final int MIN_EXP_SENIOR = 3;
    public static final int MIN_SALARY_SENIOR = 3000;
    public static final int MAX_SALARY = 5000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет, начинаем собеседование!!!");
        System.out.println("Введите возраст:");
        int age = scanner.nextInt();
        System.out.println("Введите опыт:");
        int exp = scanner.nextInt();
        System.out.println("Введите ожидаемую зарплату:");
        int salary = scanner.nextInt();

        boolean isJunior = (age >= MIN_AGE && age <= MAX_AGE_JUNIOR) &&
                           (exp == MIN_EXP_JUNIOR || exp == MAX_EXP_JUNIOR) &&
                           (salary >= MIN_SALARY_JUNIOR && salary <= MAX_SALARY_JUNIOR);

        boolean isSenior = (age > MIN_AGE_SENIOR && age <= MAX_AGE) &&
                           (exp >= MIN_EXP_SENIOR) &&
                           salary >= MIN_SALARY_SENIOR && salary <= MAX_SALARY;

        boolean isOffer = isJunior || isSenior;
        if (isOffer) {
            System.out.println("Отлично!!!");
            String message = isJunior
                    ? "Мы готовы предложить позицию джуна"
                    : "Мы готовы предложить позицию сеньора-помидора";
            System.out.println(message);
            System.out.println("Вы согласны(yes|no)?");
            String answer = scanner.next();
            if ("yes".equals(answer)) {
                System.out.println("Ура. Вы приняты");
            } else {
                System.out.println("Очень жаль");
            }
        } else {
            System.out.println("Мы вам обязательно перезвоним!!!");
        }
    }
}
