package com.javarush.module2.lesson13;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomerQueue {

    private final Queue<Customer> queue = new ArrayDeque<>();

    public synchronized void add(Customer customer) {
        queue.add(customer);
    }

    public synchronized Customer poll() {
        return queue.poll();
    }

}
