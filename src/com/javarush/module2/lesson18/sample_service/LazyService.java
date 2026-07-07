package com.javarush.module2.lesson18.sample_service;

import com.javarush.module2.lesson18.sample_service.framework.Init;
import com.javarush.module2.lesson18.sample_service.framework.Service;

@SuppressWarnings({"unused", "RedundantThrows"})
@Service(name = "Very Lazy Service", lazyLoad = true)
public class LazyService {

    @Init
    public void start() throws Exception {
        System.out.println("Very Lazy Service started");
    }

    public void stop() {
        System.out.println("Very Lazy Service stopped");
    }

    public LazyService() {
        System.out.println("Создан экземпляр Very Lazy Service");
    }
}
