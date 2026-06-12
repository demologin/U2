package com.javarush.module2.lesson08.cosmos;

import java.util.List;

public class AppGame {

    private final View view;
    private final List<BasePoint> points;

    public AppGame(View view, BasePoint... points) {
        this.view = view;
        this.points = List.of(points);
    }

    public void start(){
        points.forEach(view::showPoint);
    }
}
