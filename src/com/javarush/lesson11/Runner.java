package com.javarush.lesson11;

public class Runner {
    public static void main(String[] args) {
        Component[] components = {
                new Component(10, 20, "blue"),
                new Button(100, 200, "green","OK"),
                new Component(300, 400, "red"),
                new InputBox(42, 42,"green","input password","GreenStyle")
        };

        for (Component component : components) {
            component.show();
        }
        
        
        CharSequence[] strings = {
              "one", 
                new StringBuilder("two"), 
                new StringBuffer("three")
        };

        for (Object object : strings) {
            System.out.println(object);
        }
    }
}
