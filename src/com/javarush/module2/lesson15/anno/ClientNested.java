package com.javarush.module2.lesson15.anno;

import com.javarush.module2.lesson15.nested.NestedDemo;

public class ClientNested {
    public static void main(String[] args) {
        NestedDemo nestedDemo = new NestedDemo() {

            private String getLastName(){
                return "LastName";
            }

            private String getFirstName(){
                return "FirstName";
            }
            @Override
            public String getName() {
                return getLastName()+getFirstName();
            }
        };

        NestedDemo.NestedClass nestedClass = new NestedDemo.NestedClass(1L, "title");
    }
}
