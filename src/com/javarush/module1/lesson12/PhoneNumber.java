package com.javarush.module1.lesson12;

import java.util.Objects;

public class PhoneNumber {
    private String countryCode;
    private String operatorCode;
    private int number;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryCode, String operatorCode, int number) {
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;
        return getNumber() == that.getNumber() && Objects.equals(getCountryCode(), that.getCountryCode()) && Objects.equals(getOperatorCode(), that.getOperatorCode());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getCountryCode());
        result = 31 * result + Objects.hashCode(getOperatorCode());
        result = 31 * result + getNumber();
        return result;
    }

    @Override
    public String toString() {
        return "+" + countryCode +
               "(" + operatorCode + ")"
               + number;
    }
}
