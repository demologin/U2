package com.javarush.module2.lesson14;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomerQueue {

    private final BlockingQueue<Customer> queue=new ArrayBlockingQueue<>(10);

    public void add(Customer customer) {
        try {
            queue.put(customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer poll() {
        return queue.poll();
    }

}
