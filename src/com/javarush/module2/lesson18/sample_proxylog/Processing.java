package com.javarush.module2.lesson18.sample_proxylog;

public interface Processing {

    void createConnection(String uri);

    void openTransaction();

    void sendMoney(double count);

    double getAmount();

    void closeTransaction();

    void rollbackTransaction();

}
