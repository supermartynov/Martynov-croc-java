package ru.croc.task1;

public class Triangle {

    private Point point1;

    private Point point2;

    private Point point3;


    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public double calculateSideSize(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getY() - firstPoint.getY(), 2) +
                Math.pow(secondPoint.getX() - firstPoint.getX(), 2));
    }

    public double calculateArea() {
        double firstSideSize = calculateSideSize(point1, point2);
        double secondSideSize = calculateSideSize(point1, point3);
        double thirdSideSize = calculateSideSize(point2, point3);
        double halfP = (firstSideSize + secondSideSize + thirdSideSize) / 2;

        return Math.sqrt(halfP * (halfP - firstSideSize) * (halfP - secondSideSize) * (halfP - thirdSideSize));
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

}
