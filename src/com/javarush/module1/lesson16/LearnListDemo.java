package com.javarush.module1.lesson16;

import java.util.ArrayList;
import java.util.List;

public class LearnListDemo {

    public static void main(String[] args) {
        String[] words={"one", "two", "three", "four", "five"};
        System.out.println("list");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        System.out.println(list);
        list.remove("one");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println("size=" + list.size());

        System.out.println("myList");
        List<String> myList = new MyList<>();
        for (String word : words) {
            myList.add(word);
        }
        System.out.println(myList);
        myList.remove("one");
        System.out.println(myList);
        myList.remove(3);
        System.out.println(myList);
        System.out.println("size=" + myList.size());
    }
}
