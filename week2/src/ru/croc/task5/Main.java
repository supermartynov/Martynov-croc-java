package ru.croc.task5;

public class Main{
    public static void main(String[] args) {
        Figure circle = new Circle(1, 1, 1);
        Figure rectangle = new Rectangle(3, 4, 2, 2);
        Annotation firstAnnotation = new Annotation(circle, "Car");
        Annotation secondAnnotation = new Annotation(rectangle, "Tree");
        Annotation[] annotations = new Annotation[] {firstAnnotation, secondAnnotation};
        AnnotatedImage annotatedImage = new AnnotatedImage("some path", annotations);

        for (Annotation annotation: annotations) {
            System.out.println(annotation.toString());
        }

        System.out.println("\nПроверка координат первый метод ");
        try {
            System.out.println("Вводим координаты 2 и 3");
            annotatedImage.findByPoint(2, 3).toString(); //error
        } catch (Exception exception) {
            System.out.println("Ошибка, нет такой аннотации");
        }
        System.out.println("Вводим координаты 3 и 4");
        System.out.println("Аннотация с такими координат есть: " + annotatedImage.findByPoint(3, 4).toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Проверка координат второй метод");
        try {
            System.out.println("Вводим координаты 2 и 3");
            annotatedImage.findByPointUsingString(2, 3).toString(); //error
        } catch (Exception exception) {
            System.out.println("Ошибка, нет такой аннотации");
        }
        System.out.println("Вводим координаты 3 и 4");
        System.out.println("Аннотация с такими координатами есть: " + annotatedImage.findByPointUsingString(3, 4).toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Проверка подписи первый метод");
        try {
            System.out.println("Вводим подпись building");
            annotatedImage.findByLabel("building").toString(); //error
        } catch (Exception exception) {
            System.out.println("Ошибка, нет такой аннотации");
        }
        System.out.println("Вводим подпись Car");
        System.out.println("Аннотация с такими координатами есть: " + annotatedImage.findByLabel("Car").toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("Проверка подписи второй метод");
        try {
            System.out.println("Вводим подпись building");
            annotatedImage.findByLabelUsingString("building").toString(); //error
        } catch (Exception exception) {
            System.out.println("Ошибка, нет такой аннотации");
        }
        System.out.println("Вводим подпись Car");
        System.out.println("Аннотация с такими координатами есть: " + annotatedImage.findByLabelUsingString("Car").toString());
        System.out.println("-----------------------------------------------------");

        System.out.println("смещение круга на 2");
        System.out.println("аннотация в виде круга до смещения - " + circle.toString());
        ((Movable) circle).move(2, 2);
        System.out.println("аннотация в виде круга после смещения - " + circle.toString());


    }
}
