package com.javarush.module2.lesson17;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionApiDemo {
    public static void main(String[] args) {
        Object someObject = new Object();
        Class<?> aClass = someObject.getClass();
        System.out.println(aClass.getName());
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Method[] methods = aClass.getDeclaredMethods();
        StringBuilder out = new StringBuilder();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            Parameter[] parameters = method.getParameters();
            String parametersTypes = Arrays.toString(parameters)
                    .replace("[", "(")
                    .replace("]", ")");
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) out.append("public ");
            if (Modifier.isStatic(modifiers)) out.append("static ");
            if (Modifier.isFinal(modifiers)) out.append("final ");
            if (Modifier.isProtected(modifiers)) out.append("protected ");
            if (Modifier.isPrivate(modifiers)) out.append("private ");
            out.append(returnType.getSimpleName()).append(" ").append(method.getName()).append(parametersTypes);
            System.out.println(out);
            out.setLength(0);
        }

        Object sb = createWithName(StringBuilder.class, "Ivanov");
        System.out.println("SB: " + sb);

        Object str = createWithName(String.class, "Petrov");
        System.out.println("STR: " + str);

        Object sbuff=createWithName(StringBuffer.class, "Sidorov");
        System.out.println("SBUFF: " + sbuff);

        Object myClass = createWithName(MyClass.class, "Khmelov");
        System.out.println("myClass: " + myClass);

    }

    private static Object createWithName(Class<?> aClass, String stringValue) {
        try {
            if (aClass.getSimpleName().equals("StringBuilder")){
                Constructor<?> emptyConstructor = aClass.getConstructor();
                Object sb = emptyConstructor.newInstance();
                Method append = aClass.getMethod("append", String.class);
                append.invoke(sb,stringValue+"!!!");
                return sb;
            }
            Constructor<?> constructor = aClass.getConstructor(String.class);
            return constructor.newInstance(stringValue);
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | InstantiationException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
