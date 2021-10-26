package ru.croc.task5;
import ru.croc.task4.Circle;

public class CircleForTask5 extends Circle {

    public CircleForTask5(int x, int y, int r) {
        super(x, y, r);
    }

    public void move(int dx, int dy) {
        this.X += dx;
        this.Y += dy;
    }

}
