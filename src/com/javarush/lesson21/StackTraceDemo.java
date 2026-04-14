package com.javarush.lesson21;

import java.util.Scanner;

public class StackTraceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = readDoubleFrom(scanner);
        System.out.println(result);
    }

    private static double readDoubleFrom(Scanner scanner) {
        double result = Double.NaN;
        try {
            result = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            String message = e.getMessage();
            String exClassName = e.getClass().getName();
            System.out.printf("%s: %s%n", exClassName, message);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                String fileName = stackTraceElement.getFileName();
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("   at %s.%s(%s:%d)%n"
                        , className, methodName, fileName, lineNumber);
            }
            e.printStackTrace(System.err);
        }
        return result;
    }
}
