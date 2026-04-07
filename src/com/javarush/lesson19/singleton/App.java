package com.javarush.lesson19.singleton;

public class App {
    public static void main(String[] args) {
        Log logger1 = Log.getLog();
        Log logger2 = Log.getLog();
        Log logger3 = Log.getLog();
        Log[] loggers = {logger1, logger2, logger3};
        for (Log logger : loggers) {
            System.out.println(logger);
        }
    }
}
