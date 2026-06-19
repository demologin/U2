package com.javarush.module2.lesson12;

public class Customer extends Thread implements Operation {

    private final long id;
    private final Manager manager;

    public Customer(Manager manager, long id) {
        manager.addCustomer();
        this.manager = manager;
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
        System.out.println(this + " go to queue ");
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
