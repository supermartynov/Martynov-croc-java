
package ru.croc.task7;

public class ChessPosition {
    private char letterPosition;
    private int numberPosition;


    private static int checkNumber(int number) throws IllegalPositionException { //проверка на валидность
        if (number < 1 || number > 8) {                                          //число в позиции на шахматной доске
            throw new IllegalPositionException();
        } else {
            return number;
        }
    }

    private static char checkString(char letter) throws IllegalPositionException { //проверка на валидность
        if (letter < 'a' || letter > 'h') {                                        //букву в позиции на шахматной доске
            throw new IllegalPositionException();
        } else {
            return letter;
        }
    }

    public ChessPosition(char letterPosition, int numberPosition) throws IllegalPositionException { //конструктор ChessPosition
        char letter = checkString(letterPosition);
        int number = checkNumber(numberPosition);
        this.letterPosition = letter;
        this.numberPosition = number;
    }

    public static ChessPosition parse(String position) throws IllegalPositionException { //метод parse из условия
        char letter = position.charAt(0);
        int number = Integer.parseInt(position.substring(1, position.length()));
        return new ChessPosition(checkString(letter), checkNumber(number));
    }

    @Override
    public String toString() {
        return "<" + this.letterPosition + ">" + "<" + this.numberPosition + ">"  ;
    }

    public char getLetterPosition() {
        return letterPosition;
    }

    public int getNumberPosition() {
        return numberPosition;
    }
}


