package ru.croc.task5;

import ru.croc.task4.AnnotatedImage;
import ru.croc.task4.Annotation;

class AnnotatedImageForTask5 extends  AnnotatedImage {

    public AnnotatedImageForTask5(String imagePath, Annotation... annotations) {
        super(imagePath, annotations);
    }

    public boolean compare(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }

    public Annotation findByPoint(int x, int y) {  //первая версия метода поиска по точке
        for(Annotation annotation : annotations) {
            if (annotation.getFigure() instanceof RectangleForTask5) {
                if (compare(((RectangleForTask5) annotation.getFigure()).getX1(), ((RectangleForTask5) annotation.getFigure()).getY1(), x, y)
                    || compare(((RectangleForTask5) annotation.getFigure()).getX2(), ((RectangleForTask5) annotation.getFigure()).getY2(), x, y)) {
                    return annotation;
                }
            } else if (annotation.getFigure() instanceof CircleForTask5) {
                if (compare(((CircleForTask5) annotation.getFigure()).getX(), ((CircleForTask5) annotation.getFigure()).getY(), x, y)) {
                    return annotation;
                }
            }
        }
        return null;
    }

    public Annotation findByPointUsingString(int x, int y) {  //вторая версия метода поиска по точке
        for (Annotation annotation : annotations) {
            if (annotation.toString().contains("<" + x + ">, <" + y + ">")) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {  //первая версия метода поиска по подписи
        for (Annotation annotation : annotations) {
            if (annotation.getObjectOnPhoto().equals(label)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabelUsingString(String label) { //вторая версия метода поиска по подписи
        for (Annotation annotation : annotations) {
            if (annotation.toString().contains(label)) {
                return annotation;
            }
        }
        return null;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }
}
