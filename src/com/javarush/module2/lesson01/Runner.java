package com.javarush.module2.lesson01;

import com.javarush.module2.lesson01.repository.UserRepositoryInMemoryImpl;
import com.javarush.module2.lesson01.service.UserService;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Application application = Runner.build();
        application.run();
    }

    private static Application build(){
        UserRepositoryInMemoryImpl userRepository = new UserRepositoryInMemoryImpl();
        UserService userService = new UserService(userRepository);
        Scanner scanner = new Scanner("jh");
        return new Application(userService, scanner);
    }
}
