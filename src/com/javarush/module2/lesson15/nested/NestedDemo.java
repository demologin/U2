package com.javarush.module2.lesson15.nested;

import java.io.Serializable;

public interface NestedDemo {

    String NAME = "name";

    class NestedClass implements Serializable {
        private final Long id;
        private final String title;

        public NestedClass(Long id, String title) {
            this.id = id;
            this.title = title;
        }

        @Override
        public String toString() {
            return "NestedClass{" +
                   "id=" + id +
                   ", title='" + title + '\'' +
                   '}';
        }
    }

    String getName();
}
