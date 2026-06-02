package com.javarush.module2.lesson04;

public class Line implements Justify, Comparable<Line> {

    private final String text;

    @Override
    public String getAlignText(Align align, int maxWith) {
        if (text.length() > maxWith) {
            throw new IllegalArgumentException("Too small maxWith");
        }
        int countSpaces = maxWith - text.length();
        switch (align) {
            case LEFT -> {
                return text + " ".repeat(countSpaces);
            }
            case RIGHT -> {
                return " ".repeat(countSpaces) + text;
            }
            case CENTER -> {
                String before = " ".repeat(countSpaces / 2);
                String after = " ".repeat(maxWith - countSpaces / 2);
                return before + text + after;
            }
            case null, default -> throw new IllegalArgumentException("Incorrect align");
        }
    }

    public Line(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int compareTo(Line o) {
        return this.text.length() - o.text.length();
    }
}
