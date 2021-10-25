package ru.croc.task7;

import java.util.Arrays;
import java.util.Scanner;

public class ChessBoard {

    public static void isHorsePossible(ChessPosition firstChessPosition, ChessPosition secondChessPosition) throws IllegalMoveException {
        char firstLetter = firstChessPosition.getLetterPosition();
        char secondLetter = secondChessPosition.getLetterPosition();
        int firstNumber = firstChessPosition.getNumberPosition();
        int secondNumber = secondChessPosition.getNumberPosition();

        if (!((Math.abs(firstLetter - secondLetter) == 1 && Math.abs(firstNumber - secondNumber) == 2
                || Math.abs(firstLetter - secondLetter) == 2 && Math.abs(firstNumber - secondNumber) == 1))) {
            throw new IllegalMoveException(firstChessPosition, secondChessPosition);
        }
    }

}
