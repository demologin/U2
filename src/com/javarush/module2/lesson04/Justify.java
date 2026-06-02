package com.javarush.module2.lesson04;

public interface Justify {
    String getAlignText(Align align, int maxWith);

    default String getAlignText(int maxWith){
        return getAlignText(Align.LEFT, maxWith);
    }
}
