package com.javarush.module2.lesson18.sample_proxylog;


import com.javarush.module2.lesson18.sample_proxylog.logger.ProxyLogger;

public class Runner {
    public static void main(String[] args) {
        Processing processing = new ProcessingImpl();
        //закомментируйте следующую строку и логирование пропадет
        processing = ProxyLogger.getLoggedSender(processing);

        System.out.println("sum: $" + processing.getAmount());
        processing.createConnection("jdbc....");
        processing.openTransaction();
        processing.sendMoney(5);
        processing.closeTransaction();
        System.out.println("sum: $" + processing.getAmount());

        processing.openTransaction();
        processing.rollbackTransaction();
    }
}
