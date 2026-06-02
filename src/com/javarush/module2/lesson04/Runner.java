package com.javarush.module2.lesson04;

import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Data.TEXT);
        Comparator<Line> lineComparator = Comparator.comparingInt(o -> o.toString().length());
        Collection<Line> lines = new TreeSet<>(lineComparator);
        int maxWith = 0;

        while (scanner.hasNextLine()) {
            String txt = scanner.nextLine();
            if (txt.length() > maxWith) {
                maxWith = txt.length();
            }
            Line line = new Line(txt);
            lines.add(line);
        }

        showCollection(lines, Align.DEFAULT, maxWith);
        showCollection(lines, Align.CENTER, maxWith);
        showCollection(lines, Align.LEFT, maxWith);
        showCollection(lines, Align.RIGHT, maxWith);
    }

    private static void showCollection(Collection<Line> lines, Align align, int maxWith) {
        for (Line line : lines) {
            String alignText = align == Align.DEFAULT
                    ? line.getAlignText(maxWith)
                    : line.getAlignText(align, maxWith);
            System.out.println(alignText);
        }
    }
}
