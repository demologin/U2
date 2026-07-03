package com.javarush.module2.lesson15.inner;

import java.util.concurrent.atomic.AtomicInteger;

public class InnerContainer {

    private String name;

    public InnerContainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class InnerClass {
        private final Long id;
        private final String title;
        private final String description;

        private static final AtomicInteger count=new AtomicInteger();

        public static int getCount() {
            return count.get();
        }

        InnerClass(Long id, String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
            count.incrementAndGet();
        }

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
