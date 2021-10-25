package ru.croc.task7;

public class IllegalMoveException extends Exception{
    ChessPosition firstPosition;
    ChessPosition secondPosition;

    public IllegalMoveException(ChessPosition firstPosition, ChessPosition secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    @Override
    public String toString() {
        return "конь так не ходит: " + this.firstPosition.getLetterPosition() + this.firstPosition.getNumberPosition()
                + "->" + this.secondPosition.getLetterPosition() + this.secondPosition.getNumberPosition();

    }
}
