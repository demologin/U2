package com.javarush.lesson05;

public class WhileDemo {
    public static void main(String[] args) {
        int start=10;
        while (start>0){
            System.out.println("Start="+start);
            start--;
        }
        System.out.println("Finished");
    }
}
