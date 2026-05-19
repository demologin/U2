package com.javarush.module1.lesson12;

import java.util.Arrays;

public class PhoneBook {

    public static final int SIZE = 1 << 20;

    private final PhoneNumber[][] phoneNumbers = new PhoneNumber[SIZE][0];

    public boolean add(PhoneNumber phoneNumber) {
        if (!containsPhoneNumber(phoneNumber)) {
            int pos = phoneNumber.hashCode() % SIZE;
            phoneNumbers[pos] = Arrays.copyOf(phoneNumbers[pos], phoneNumbers[pos].length + 1);
            phoneNumbers[pos][phoneNumbers[pos].length-1]=phoneNumber;
            return true;
        }
        return false;
    }

    public boolean containsPhoneNumber(PhoneNumber phoneNumber) {
        int pos = phoneNumber.hashCode() % SIZE;
        PhoneNumber[] possiblePhones = phoneNumbers[pos];
        for (PhoneNumber possiblePhone : possiblePhones) {
            if (possiblePhone.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
