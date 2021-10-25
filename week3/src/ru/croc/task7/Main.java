package ru.croc.task7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] positions = scanner.nextLine().split(", "); //считываем строку
        ChessPosition[] chessPositions = new ChessPosition[positions.length];

        for (int i = 0; i < positions.length; i++) { //создаем массив позиций
            try {
                chessPositions[i] = ChessPosition.parse(positions[i]);
                System.out.println("№" + (i + 1) + " " + chessPositions[i].toString());
            } catch (IllegalPositionException err) {
                System.out.println(err.toString());
                System.exit(1);
            }
        }

        if (chessPositions.length == 1) {
            System.out.println("Вы ввели одно поле");
            System.exit(1);
        }

        int errorsCounter = 0;

        for (int i = 0; i < chessPositions.length - 1; i++) { //проверяем можно ли ходить конем
            try {
                ChessBoard.isHorsePossible(chessPositions[i], chessPositions[i + 1]);
            } catch (IllegalMoveException err) {
                errorsCounter++;
                System.out.println(err.toString());
            }
        }

        if (errorsCounter == 0) {
            System.out.println("Ok");
        }
    }
}
