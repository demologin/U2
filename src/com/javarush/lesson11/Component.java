package com.javarush.lesson11;

public class Component { //POJO

    private int x;
    private int y;
    private  String color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = Math.max(x,0);
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Component() {
        x=0;
        y=0;
        color="white";
    }

    public Component(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Component [x=%d, y=%d, color=%s]", x, y, color);
    }
}
