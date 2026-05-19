package com.javarush.module1.lesson13;

 class RunLogger {
    public static void main(String[] args) {
        Application[] applications = {
                new Application(),
                new Application(),
                new Application(),
                new Application(),
                new Application(),
        };
        applications[applications.length - 1].setIndex(42);
        for (Application application : applications) {
            Application.updateValueCounter(442);
            String title = application.getTitle();
            System.out.println(title);
            System.LoggerFinder loggerFinder = System.LoggerFinder.getLoggerFinder();
        }
    }
}

 public class Runner{
    public void print(String message){
        System.out.println(message);
    }
}
