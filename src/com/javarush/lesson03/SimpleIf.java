package com.javarush.lesson03;

import java.util.Scanner;

public class SimpleIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст");
        int age = scanner.nextInt();
        if (age < 18) {
            System.out.println("Ты еще ребенок");
            System.out.println("Не спорь со взрослыми");
        } else if (age > 60) {
            System.out.println("Вы уже очень взрослый");
            System.out.println("Ну и молодежь пошла");
        } else
            System.out.println("Пора работать");
        System.out.println("Прощай");


    }

}
