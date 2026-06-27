package com.javarush.module2.lesson14;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {

    private final int plan;
    private final AtomicInteger countIn=new AtomicInteger(0);
    private final AtomicInteger countOut=new AtomicInteger(0);

    public Manager(int plan) {
        this.plan = plan;
    }

    public boolean storeIsOpened() {
        return countIn.get() != plan;
    }

    public boolean storeIsClosed() {
        return countOut.get() == plan;
    }

    public void addCustomer() {
        countIn.incrementAndGet();
        if (countIn.get() > plan) {
            throw new RuntimeException("Inconsistent state in");
        }
    }

    public void leavesCustomer() {
        countOut.incrementAndGet();
        if (countOut.get() > plan) {
            throw new RuntimeException("Inconsistent state out");
        }
    }

    @Override
    public String toString() {
        return "in=" + countIn + " out=" + countOut;
    }
}
