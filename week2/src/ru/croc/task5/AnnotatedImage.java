package ru.croc.task5;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public boolean compare(int x1, int y1, int x2, int y2) {
        return x1 == x2 && y1 == y2;
    }


    public Annotation findByPoint(int x, int y) {  //первая версия метода поиска по точке
        for(Annotation annotation : annotations) {
            if (annotation.getFigure() instanceof Rectangle) {
                if (compare(((Rectangle) annotation.getFigure()).getX1(), ((Rectangle) annotation.getFigure()).getY1(), x, y)
                    || compare(((Rectangle) annotation.getFigure()).getX2(), ((Rectangle) annotation.getFigure()).getY2(), x, y)) {
                    return annotation;
                }
            } else if (annotation.getFigure() instanceof Circle) {
                if (compare(((Circle) annotation.getFigure()).getX(), ((Circle) annotation.getFigure()).getY(), x, y)) {
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
