package com.javarush.module2.lesson17.simple;

public class Config {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private int maxConnections;
    private byte maxIdle;

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public byte getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(byte maxIdle) {
        this.maxIdle = maxIdle;
    }

    @Override
    public String toString() {
        return "Config{" +
               "\n\tdbUrl='" + dbUrl + '\'' +
               "\n\tdbUser='" + dbUser + '\'' +
               "\n\tdbPassword='" + dbPassword + '\'' +
               "\n\tmaxConnections=" + maxConnections +
               "\n\tmaxIdle=" + maxIdle +
               '}';
    }
}
