package com.javarush.lesson16;

import java.util.*;

public class WordProcessor {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer(Data.TEXT, "–—,./;'[]{}<>?:\"|1234567890!@#$%^&*()-_=+`~\n\t ");
        List<String> list = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Deque<String> deque = new ArrayDeque<>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            list.add(word);
            linkedList.add(word);
            deque.addFirst(word);
            hashSet.add(word);
            linkedHashSet.add(word);
            treeSet.add(word);
        }
        String removed = list.remove(1);
        boolean syntax = list.remove("Syntax");
        list.removeLast();
        System.out.println("list=" + list);
        System.out.println("list words count=" + list.size());

        linkedList.addAll(list);
        System.out.println("linkedList=" + linkedList);
        System.out.println("linkedList words count=" + linkedList.size());

        deque.removeAll(list);
        System.out.println("deque=" + deque);
        System.out.println("deque words count=" + deque.size());

        System.out.println("hashSet=" + hashSet);
        System.out.println("hashSet words count=" + hashSet.size());

        System.out.println("linkedHashSet=" + linkedHashSet);
        System.out.println("linkedHashSet words count=" + linkedHashSet.size());

        System.out.println("treeSet=" + treeSet);
        System.out.println("treeSet words count=" + treeSet.size());
    }
}
