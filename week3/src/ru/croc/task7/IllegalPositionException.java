package ru.croc.task7;

public class IllegalPositionException extends Exception{

    @Override
    public String toString() {
        return "Неверно введенные координаты.\n " +
                "Допустимый диапазон букв - от a до h. \n" +
                "Допустимый диапазон цифр - от 1 до 8. \n";
    }

}
