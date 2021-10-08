package ru.croc.task1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату х вершины №1:");
        double x1 = scanner.nextDouble();
        System.out.println("Введите координату y вершины №1:");
        double y1 = scanner.nextDouble();
        System.out.println("Введите координату х вершины №2:");
        double x2 = scanner.nextDouble();
        System.out.println("Введите координату y вершины №2:");
        double y2 = scanner.nextDouble();
        System.out.println("Введите координату х вершины №3:");
        double x3 = scanner.nextDouble();
        System.out.println("Введите координату y вершины №3:");
        double y3 = scanner.nextDouble();

        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Point point3 = new Point( x3, y3);

        Triangle triangle = new Triangle(point1, point2, point3);
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        System.out.println("Площадь треугольника : " + decimalFormat.format(triangle.calculateArea()));
    }
}
