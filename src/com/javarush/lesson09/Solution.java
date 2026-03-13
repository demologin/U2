package com.javarush.lesson09;

public class Solution {
    public int count = 0;
    public int sum = 0;

    public void add(int data) {
        sum = sum + data;
        int sum = data * 2;
        count++;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.add(42);
    }

}