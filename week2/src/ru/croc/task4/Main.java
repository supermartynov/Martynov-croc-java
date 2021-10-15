package ru.croc.task4;

public class Main{
    public static void main(String[] args) {
        Figure circle = new Circle(1, 1, 1);
        Figure rectangle = new Rectangle(1, 1, 2, 2);
        Annotation firstAnnotation = new Annotation(circle, "Car");
        Annotation secondAnnotation = new Annotation(rectangle, "Tree");
        Annotation[] annotations = new Annotation[] {firstAnnotation, secondAnnotation};

        for (Annotation annotation: annotations) {
            System.out.println(annotation.toString());
        }
    }
}
