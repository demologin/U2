package com.javarush.module2.lesson17.simple;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertyConvertor {
    public static void main(String[] args) {
        User user = getByClass(User.class);
        System.out.println(user);

        Config config = getByClass(Config.class);
        System.out.println(config);
    }

    private static <T> T getByClass(Class<T> pojoClass) {
        try {
            Constructor<T> emptyConstrictor = pojoClass.getConstructor();
            if (emptyConstrictor.trySetAccessible()) {
                T result = emptyConstrictor.newInstance();
                String simpleName = pojoClass.getSimpleName();
                InputStream inputStream = pojoClass
                        .getResourceAsStream(simpleName.toLowerCase() + ".properties");
                try (inputStream) {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    Field[] fields = pojoClass.getDeclaredFields();
                    for (Field field : fields) {
                        String fieldName = field.getName();
                        String key = convertCamelCaseToKebabStyle(fieldName);
                        String value = properties.getProperty(key);
                        Class<?> type = field.getType();
                        Object realValue = mapper(type, value);
                        String setterName = "set"
                                            + fieldName.substring(0, 1).toUpperCase()
                                            + fieldName.substring(1);
                        Method setter = pojoClass.getMethod(setterName, type);
                        setter.invoke(result, realValue);
                    }
                }
                return result;
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 IOException e) {
            throw new RuntimeException(e);
        }
        throw new IllegalStateException("invalid constructor");
    }

    private static Object mapper(Class<?> type, String value) {
        Function<String,Object> mapper=switch (type.getSimpleName()){
            case "Integer","int" -> Integer::valueOf;
            case "Long","long" -> Long::valueOf;
            case "Double","double" -> Double::valueOf;
            case "Byte","byte" -> Byte::valueOf;
            case "String" -> String::valueOf;
            case "LocalDateTime" -> LocalDateTime::parse;
            case "LocalDate" -> LocalDate::parse;
            case "LocalTime" -> LocalTime::parse;
            default -> throw new IllegalStateException("invalid type");
        };
        return mapper.apply(value);
    }

    private static String convertCamelCaseToKebabStyle(String string) {
        String kebabName = string.chars()
                .mapToObj(s -> String.valueOf((char) s))
                .flatMap(s -> s.matches("[A-Z]")
                        ? Stream.of("-", s)
                        : Stream.of(s))
                .collect(Collectors.joining())
                .toLowerCase();
        return kebabName.startsWith("-")
                ? kebabName.substring(1)
                : kebabName;
    }
}
