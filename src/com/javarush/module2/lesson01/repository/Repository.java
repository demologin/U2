package com.javarush.module2.lesson01.repository;

import java.util.Collection;

public interface Repository<K, E> {

    Collection<E> findAll();

    E getById(K id);

    void save(E entity);

    void delete(E entity);

    void update(E entity);

}
