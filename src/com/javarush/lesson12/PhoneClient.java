package com.javarush.lesson12;

public class PhoneClient {

    public static void main(String[] args) {
        String ru="7";
        String by="375";
        String us="1";
        String ua="380";
        PhoneBook phoneBook = new PhoneBook();
        PhoneNumber ruNumber = new PhoneNumber(ru, "904", 1234567);
        PhoneNumber ruNumber2 = new PhoneNumber(ru, "904", 1234568);
        phoneBook.add(ruNumber);
        phoneBook.add(new PhoneNumber(by,"33",7654321));
        phoneBook.add(ruNumber); //repeat number
        phoneBook.add(new PhoneNumber(ua,"50",2345678));
        if (phoneBook.containsPhoneNumber(ruNumber2)) {
            System.out.println(ruNumber+" exists");
        } else {
            System.out.println(ruNumber2+" not found");
        }
    }
}
