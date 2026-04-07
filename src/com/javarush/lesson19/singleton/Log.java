package com.javarush.lesson19.singleton;

public class Log {

    public static final Log INSTANCE = new Log();

    private Log(){

    }

    public static Log getLog() {
        return INSTANCE;
    }
}
