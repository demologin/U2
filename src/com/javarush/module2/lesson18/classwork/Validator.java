package com.javarush.module2.lesson18.classwork;

import java.lang.reflect.Field;

public class Validator {

    public static boolean checkLimit(Object object) {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.isAnnotationPresent(Limit.class)) {
                    field.setAccessible(true);
                    Limit limit = field.getAnnotation(Limit.class);
                    Object value = field.get(object);
                    if (value == null){
                        if (limit.nullable()){
                            continue;
                        } else {
                            System.out.println("Field " + field.getName() + " is null");
                            return false;
                        }
                    }
                    if (value.toString().length()<limit.minSymbolLength()){
                        System.out.println("Field " + field.getName() + " is too short");
                        return false;
                    }
                    if (limit.minValue()!=Double.NEGATIVE_INFINITY
                    || limit.maxValue()!=Double.POSITIVE_INFINITY){
                        if (value instanceof Number number){
                            if (number.doubleValue()<limit.minValue() || number.doubleValue()>limit.maxValue()){
                                System.out.println("Field " + field.getName() + " not valid");
                                return false;
                            }
                        } else {
                            throw new NumberFormatException("Field " + field.getName() + " is not a number");
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
