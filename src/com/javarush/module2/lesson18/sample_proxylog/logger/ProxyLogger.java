package com.javarush.module2.lesson18.sample_proxylog.logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Logger для объектов на интерфейсе T
 */
public class ProxyLogger {

    //метод, который создает прокси-объект
    @SuppressWarnings("unchecked")
    public static <T> T getLoggedSender(T target) {
        return (T) Proxy.newProxyInstance(
              target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                createInvocationHandler(target)
        );
    }

    private static <T> InvocationHandler createInvocationHandler(T target) {
        return (proxy, methodProxy, args) -> {
            Method method=target.getClass()
                    .getMethod(
                            methodProxy.getName(),
                            (Class<?>[]) methodProxy.getGenericParameterTypes());
            if (method.isAnnotationPresent(Log.class)){
                log(method);
            }
            return method.invoke(target, args);
        };
    }


    //метод вывода лога в консоль с данными его аннотации
    private static void log(Method method) {
        Log a = method.getAnnotation(Log.class);
        System.out.printf("%sLevel:%-10s"+Colors.ANSI_RESET+" Name: %-20s LOG: %s\n",
                a.level().color, a.level(), method.getName(), a.text()
        );
    }

}
