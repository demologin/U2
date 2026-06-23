package com.javarush.module2.lesson13;

public class Customer implements Runnable, Operation {

    private final long id;
    private final Manager manager;
    private final CustomerQueue customerQueue;

    private boolean waiting;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }


    public Object getMonitor() {
        return this;
    }

    public Customer(long id, Manager manager, CustomerQueue customerQueue) {
        manager.addCustomer();
        this.manager = manager;
        this.customerQueue = customerQueue;
        this.id = id;
        System.out.println(manager);
    }

    @Override
    public void run() {
        enterToStore();
        chooseGoods();
        goToQueue();
        leavesStore();
        manager.leavesCustomer();
    }

    @Override
    public void enterToStore() {
        System.out.println(this + " enters to store ");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start to chooses goods ");
        int timeout = Utils.getRandom(2000, 5000);
        Utils.sleep(timeout);
        System.out.println(this + " finished to chooses goods ");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to the queue ");
        synchronized (getMonitor()) {
            waiting = true;
            customerQueue.add(this);
            while (waiting) {
                try {
                    getMonitor().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(this + " leaves the queue ");
    }

    @Override
    public void leavesStore() {
        System.out.println(this + " leaves the store ");
    }

    @Override
    public String toString() {
        return "Customer #[" + id + "] ";
    }
}
