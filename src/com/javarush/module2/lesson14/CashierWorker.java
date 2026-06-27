package com.javarush.module2.lesson14;

import java.util.concurrent.Callable;

public class CashierWorker implements Callable<Long> {

    private final CustomerQueue customerQueue;
    private final Manager manager;
    private long sum;
    private final int number;

    public CashierWorker(int number, CustomerQueue customerQueue, Manager manager) {
        this.number = number;
        this.customerQueue = customerQueue;
        this.manager = manager;
    }

    @Override
    public Long call() throws Exception {
        System.out.println(this + "started");
        while (!manager.storeIsClosed()) {
            Customer customer = customerQueue.poll();
            if (customer != null) {
                System.out.println(this + " start service " + customer);
                int timeout = Utils.getRandom(2000, 5000);
                Utils.sleep(timeout);
                sum += 10;
                    customer.setWaiting(false);
                synchronized (customer.getMonitor()){
                customer.getMonitor().notifyAll();
               }
                System.out.println(this + " finished service " + customer);
            } else {
                //see pattern Producer-Consumer https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem
                Thread.onSpinWait();
            }
        }
        System.out.println(this + "finished with sum=" + sum);
        return sum;
    }

    @Override
    public String toString() {
        return "\tCashier #" + number + ": ";
    }
}
