package com.javarush.module2.lesson08;

import java.sql.SQLData;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        Class<?>[] classes={
                int.class,
                String.class,
                StringBuilder.class,
                Integer.class,
                SQLData.class,
                ClassLoaderDemo.class
        };
        for (Class<?> aClass : classes) {
            printInfo(aClass);
        }
        System.out.println("=".repeat(20));
        ClassLoader appClassloader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(appClassloader);
        ClassLoader classloaderParent = appClassloader.getParent();
        System.out.println(classloaderParent);
        ClassLoader rootClassLoader = classloaderParent.getParent();
        System.out.println(rootClassLoader);
    }

    private static void printInfo(Class<?> aClass) {
        String name = aClass.getName();
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.printf("%s: %s%n", name, classLoader);
    }
}
