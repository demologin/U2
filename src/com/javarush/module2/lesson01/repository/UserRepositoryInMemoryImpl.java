package com.javarush.module2.lesson01.repository;

import com.javarush.module2.lesson01.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepositoryInMemoryImpl implements Repository<Long, User> {

    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);


    @Override
    public Collection<User> findAll() {
        return users.values();
    }

    @Override
    public User getById(Long id) {
        return users.get(id);
    }

    @Override
    public void save(User entity) {
        long newId = idGenerator.incrementAndGet();
        entity.setId(newId);
        users.put(newId, entity);
    }

    @Override
    public void delete(User entity) {
        users.remove(entity.getId());
    }

    @Override
    public void update(User entity) {
        users.put(entity.getId(), entity);
    }
}
