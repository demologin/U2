package com.javarush.lesson11;

public class InputBox extends Component {

    private String text;
    private String style;

    public InputBox(int x, int y, String color, String text, String style) {
        super(x, y, color);
        this.text = text;
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return String.format("InputBox[x=%d, y=%d, color=%s, text=%s, style=%s",
                getX(), getY(), getColor(), getText(), getStyle());
    }
}
