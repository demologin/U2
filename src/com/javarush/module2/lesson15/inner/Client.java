package com.javarush.module2.lesson15.inner;

public class Client {
    public static void main(String[] args) {
        InnerContainer innerContainer = new InnerContainer("my container");
        InnerContainer.InnerClass innerClass =
                innerContainer.new InnerClass(2L,"ok","inner");
        ChildInnerContainer.ChildInnerClass childInnerClass =
                new ChildInnerContainer("child container")
                .new ChildInnerClass(3L, "ok", "child");
    }
}
