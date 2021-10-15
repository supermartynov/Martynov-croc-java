package ru.croc.task4;

public class Rectangle implements Figure {
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    private final String abbreviation = "R";

    public Rectangle(int x1, int y1, int x2, int y2) {
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
    }

    public int getX1() {
        return X1;
    }

    public void setX1(int x1) {
        X1 = x1;
    }

    public int getY1() {
        return Y1;
    }

    public void setY1(int y1) {
        Y1 = y1;
    }

    public int getX2() {
        return X2;
    }

    public void setX2(int x2) {
        X2 = x2;
    }

    public int getY2() {
        return Y2;
    }

    public void setY2(int y2) {
        Y2 = y2;
    }

    @Override
    public String toString() {
        return this.abbreviation +  "(<" + this.X1 + ">, <" + this.Y1 +  ">)," +
                                    "(<" + this.X2 + ">, <" + this.Y2 + ">): ";

    }
}
