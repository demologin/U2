package com.javarush.module2.lesson17.complex;

public class Db {

    private String url;

    private String user;

    private String password;

    @Override
    public String toString() {
        return "Db{" +
               "\n\tdbUrl='" + url + '\'' +
               "\n\tdbUser='" + user + '\'' +
               "\n\tdbPassword='" + password + '\'' +
               "\n\t}";
    }
}
