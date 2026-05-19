package com.javarush.module1.lesson13;

public class Department {

    class InnerClass {

    }

    static void print() {
        System.out.println("static method");
    }

    private static int counter;

    static {
        System.out.println("static block (1) counter=" + counter);
    }

    {
        System.out.println("Logic (1) Field id=" + this.id);
    }

    private int id;

    {
        this.id = 8;
        System.out.println("Logic (2) Field id=" + this.id);
    }

    static {
        counter = 42;
        System.out.println("static block (2) counter=" + counter);
    }

    public Department(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
               "id=" + id +
               '}';
    }

    public static void main(String[] args) {
        Department department1 = new Department(7);
        System.out.println(department1);
        Department department2 = new Department(77);
        System.out.println(department2);
        InnerClass innerClass = department1.new InnerClass();
    }

}
