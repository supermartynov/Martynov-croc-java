package ru.croc.task4;

public class Circle implements Figure{
    protected int X;
    protected int Y;
    protected int R;
    protected final String abbreviation = "C";

    @Override
    public String toString() {
        return this.abbreviation + " (<" + this.X + ">, <" + this.Y +  ">), <" +this.R + ">: ";
    }

    public Circle(int x, int y, int r) {
        X = x;
        Y = y;
        R = r;
    }



    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }
}
