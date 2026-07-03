package com.javarush.module2.lesson15.inner;

public class ChildInnerContainer extends InnerContainer {

    public ChildInnerContainer(String name) {
        super(name);
    }

    class ChildInnerClass extends InnerContainer.InnerClass{
        ChildInnerClass(Long id, String title, String description) {
            super(id, title, description);
        }
    }
}
