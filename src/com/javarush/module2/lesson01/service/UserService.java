package com.javarush.module2.lesson01.service;

import com.javarush.module2.lesson01.entity.User;
import com.javarush.module2.lesson01.repository.Repository;

import java.util.Collection;
import java.util.InputMismatchException;

public class UserService {

    private final Repository<Long, User> userRepository;

    public UserService(Repository<Long, User> userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        if (validate(user)) {
            userRepository.save(user);
        } else {
            throw new InputMismatchException("Incorrect data for user: " + user);
        }
    }

    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    private boolean validate(User user) {
        if (user.getId() == null || user.getId() < 0L) {
            return false;
        }
        if (user.getName() == null) {
            return false;
        }
        return user.getName().length() >= 3;
    }

}
