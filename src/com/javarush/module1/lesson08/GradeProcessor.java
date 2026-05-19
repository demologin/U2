package com.javarush.module1.lesson08;

import java.util.Scanner;

public class GradeProcessor {

    public static void main(String[] args) {
        String input = "10 dsdsfsd 1  dfsfsd 2 sdfsf 3 4 5 6 7 8 9 0";
        Scanner scanner = new Scanner(input);
        int[] grades = InOut.inputGrades(scanner);

        InOut.printArray(grades);
        InOut.printArray(grades, ":");

        int median = Statistics.getMedian(grades);
        int min = Statistics.getMin(grades);
        int max = Statistics.getMax(grades);
        int sum = Statistics.getSum(grades);
        double avg = Statistics.getAverage(grades);
        InOut.printArray(grades, "{", "; ", "}");
        System.out.println("Statistics:");
        System.out.printf("Median=%d Min=%d Max=%d Sum=%d Avg=%f%n",
                median, min, max, sum, avg);
    }


}
