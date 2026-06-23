package com.javarush.module2.lesson13;

public class Manager {

    private final int plan;
    private volatile int countIn;
    private volatile int countOut;

    public Manager(int plan) {
        this.plan = plan;
    }

    public synchronized boolean storeIsOpened() {
        return countIn != plan;
    }

    public synchronized boolean storeIsClosed() {
        return countOut == plan;
    }

    public synchronized void addCustomer() {
        countIn++;
        if (countIn > plan) {
            throw new RuntimeException("Inconsistent state in");
        }
    }

    public synchronized void leavesCustomer() {
        countOut++;
        if (countOut > plan) {
            throw new RuntimeException("Inconsistent state out");
        }
    }

    @Override
    public String toString() {
        return "in=" + countIn + " out=" + countOut;
    }
}
