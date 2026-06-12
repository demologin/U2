package com.javarush.module2.lesson08.cosmos;

public class View {

    public void showPoint(BasePoint basePoint) {
        System.out.println(basePoint.toString()+" length="+basePoint.getLength());
    }
}
