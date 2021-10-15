package ru.croc.task4;

public class Annotation {
    private Figure figure;
    private String objectOnPhoto;

    public Annotation(Figure figure, String objectOnPhoto) {
        this.figure = figure;
        this.objectOnPhoto = objectOnPhoto;
    }

    public String getObjectOnPhoto() {
        return objectOnPhoto;
    }

    public void setObjectOnPhoto(String objectOnPhoto) {
        this.objectOnPhoto = objectOnPhoto;
    }

    @Override
    public String toString() {
        return figure.toString() + objectOnPhoto;
    }
}
