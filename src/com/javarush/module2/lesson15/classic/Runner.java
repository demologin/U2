package com.javarush.module2.lesson15.classic;

public class Runner {
    public static void main(String[] args) {
        Order order = new Order();
        print(order);
        OrderImmutable orderImmutable = new OrderImmutable(1L, "Ok", "txt");
    }

    private static void print(Order order) {
        System.out.println(order);
    }
}
