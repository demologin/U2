package com.javarush.module2.lesson08.cosmos;

public class Runner {
    public static void main(String[] args) {
        View gameView = new View();
        Point3D someDefaultPoint3D = new Point3D();
        gameView.showPoint(someDefaultPoint3D);
        //
        BasePoint[] points={
                new Point1D(10),
                new Point2D(3,4),
                someDefaultPoint3D,
                new Point2D(5,6),
                new Point3D(7,8,9)
        };
        AppGame appGame = new AppGame(gameView, points);
        appGame.start();
    }
}
