package com.javarush.module2.lesson17.complex;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;
import java.util.function.Function;

public class ConfigReader {

    public static final String APPLICATION_PROPERTIES = "application.properties";

    public static void main(String[] args) {
        Setting setting = load(Setting.class,"");
        System.out.println(setting);
    }

    private static <T> T load(Class<T> configClass, String prefix) {
        try {
            InputStream configData = configClass.getResourceAsStream(APPLICATION_PROPERTIES);
            Properties properties = new Properties();
            properties.load(configData);

            Constructor<T> defaultConstructor = configClass.getConstructor();
            T instance = defaultConstructor.newInstance();

            Field[] fields = configClass.getDeclaredFields();
            for (Field field : fields) {
                String key = prefix + convertCamelCaseToKebabStyle(field.getName());
                String stringValue = properties.getProperty(key);
                int modifiers = field.getModifiers();
                if ( !Modifier.isFinal(modifiers)) {
                    Object target = Modifier.isStatic(modifiers) ? null : instance;
                    setValue(field, target, stringValue);
                }
            }


            return instance;
        } catch (IOException
                 | NoSuchMethodException
                 | InvocationTargetException
                 | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setValue(Field field, Object target, String stringValue) {
        Class<?> type = field.getType();
        String simpleName = type.getSimpleName();
        Function<String, Object> converter = switch (simpleName) {
            case "double", "Double" -> Double::parseDouble;
            case "float", "Float" -> Float::parseFloat;
            case "byte", "Byte" -> Byte::parseByte;
            case "short", "Short" -> Short::parseShort;
            case "int", "Integer" -> Integer::parseInt;
            case "long", "Long" -> Long::parseLong;
            case "boolean", "Boolean" -> Boolean::parseBoolean;
            case "char", "Character" -> s -> s.charAt(0);
            case "LocalDate" -> LocalDate::parse;
            case "LocalTime" -> LocalTime::parse;
            case "LocalDateTime" -> LocalDateTime::parse;
            case "String" -> s -> s;
            default -> s->load(type,field.getName()+".");
        };
        try {
            field.trySetAccessible();
            field.set(target, converter.apply(stringValue));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    private static String convertCamelCaseToKebabStyle(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        name.chars().forEach(c -> {
            if (Character.isUpperCase(c)) {
                stringBuilder.append("-");
                stringBuilder.append((char) Character.toLowerCase(c));
            } else {
                stringBuilder.append((char) c);
            }
        });
        return stringBuilder.toString();
    }
}
