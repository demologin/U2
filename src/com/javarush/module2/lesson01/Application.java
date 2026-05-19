package com.javarush.module2.lesson01;

import com.javarush.module2.lesson01.entity.Manager;
import com.javarush.module2.lesson01.entity.User;
import com.javarush.module2.lesson01.service.UserService;

import java.util.Collection;
import java.util.Scanner;

public class Application {

    private final UserService userService;
    private final Scanner scanner;

    public Application(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    public void run() {
        User[] users = {
                new User("Ivan", 24),
                new User("Oleg", 32),
                new User("Olga", 22),
                new Manager()
        };
        for (User user : users) {
            userService.create(user);
        }
        Collection<User> all = userService.getAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
