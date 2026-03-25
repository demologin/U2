package com.javarush.lesson13;

public class Application {

    private static int counter;

    public static void updateValueCounter(int counter) {
        Application.counter = Math.max(counter, Application.counter);
    }

    private String title;
    private int index;

    public Application() {
        Application.counter++;
        this.setIndex(Application.counter);
        this.title = "app #" + this.index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        this.title = "app #" + this.index;
        updateValueCounter(index);
    }

    @Override
    public String toString() {
        return "Application{" +
               "counter=" + counter +
               '}';
    }
}
