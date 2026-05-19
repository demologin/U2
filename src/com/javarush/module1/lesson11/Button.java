package com.javarush.module1.lesson11;

public class Button extends Component {

    private final String text;

    public Button(int x, int y, String color, String text) {
        super(x, y, color);
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("Button[x=%d,y=%d,color=%s, text=%s",
                super.getX(),getY(),getColor(),text);
    }
}
