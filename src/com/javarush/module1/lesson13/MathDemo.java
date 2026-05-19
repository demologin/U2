package com.javarush.module1.lesson13;

public class MathDemo {
    public static void main(String[] args) {
        double x=123;
        double y=456;
        double z=987;
        double lengthXZYPoint = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        System.out.println("lengthXZYPoint="+lengthXZYPoint);
        com.javarush.module1.lesson13.RunLogger.main(args);
        Runner runner = new Runner();
        runner.print("Hello World");
    }
}
