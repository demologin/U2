package com.javarush.module2.lesson18.sample_service;

import static com.javarush.module2.lesson18.sample_service.framework.AnnotationProcess.processServiceCreate;

public class App {
    public static void main(String[] args) {
        processServiceCreate(SimpleService.class);
        processServiceCreate(LazyService.class);
        processServiceCreate(Integer.class);
        processServiceCreate(MyInteger.class);
        //еще можно так получить классы
        //Integer i=0; i.getClass;
        //или так Grade.forName("java.lang.Integer");
    }
}
