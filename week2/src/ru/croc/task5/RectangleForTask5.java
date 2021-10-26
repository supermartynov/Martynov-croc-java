package ru.croc.task5;

import ru.croc.task4.Rectangle;

public class RectangleForTask5 extends Rectangle  {

    public RectangleForTask5(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void move(int dx, int dy) {
        this.X1 += dx;
        this.Y1 += dy;
        this.X2 += dx;
        this.Y2 += dy;
    }
}
