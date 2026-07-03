package com.javarush.module2.lesson17.complex;

import java.io.Serializable;

public class Setting implements Serializable {

    Db db;

    Limit limit;

    @Override
    public String toString() {
        return "Setting{" +
               "\ndb=" + db +
               "\nlimit=" + limit +
               '}';
    }
}
