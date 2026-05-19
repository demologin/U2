package com.javarush.module1.lesson09;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class CurrencyProcessor {
    public static void main(String[] args) {
        String input = "USD\n    RUR, BYN, UAH\n BTN \n CAD EUR\nend\n";
        Scanner scanner = new Scanner(input);

        StringBuilder output = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) {
                break;
            }
            output.append(line);
        }
        System.out.println("Raw out: "+output);

        String string = output.toString();
        StringTokenizer stringTokenizer = new StringTokenizer(string," ,");
        int currencyCount = stringTokenizer.countTokens();
        String[] currencyNames = new String[currencyCount];
        int index=0;
        while (stringTokenizer.hasMoreTokens()) {
            String inputToken = stringTokenizer.nextToken();
            currencyNames[index++] = inputToken.toLowerCase();
        }

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (String currencyName : currencyNames) {
            stringJoiner.add(currencyName);
        }
        String result = stringJoiner.toString();
        System.out.println(result);
    }
}
