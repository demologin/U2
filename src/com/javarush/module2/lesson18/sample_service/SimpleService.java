package com.javarush.module2.lesson18.sample_service;

import com.javarush.module2.lesson18.sample_service.framework.Init;
import com.javarush.module2.lesson18.sample_service.framework.Service;

@Service(name = "Just simple Service")
public class SimpleService {

    @Init
    public void initialization() {
        System.out.println("Инициализация Just Service запущена");
    }

    public void halt() {
        System.out.println("Just Service остановлен");
    }

    public SimpleService() {
        System.out.println("Создан экземпляр Just Service ");
    }
}
