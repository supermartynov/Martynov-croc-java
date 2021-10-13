package ru.croc.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String stringNumber = scanner.nextLine();
        String[] size = new String[] {"B", "KB", "MB", "GB", "TB"};
        double number = Double.parseDouble(stringNumber);
        int i = 0;

        while (number > 1023) {
            number = number / 1024;
            i++;
        }

        try {
            System.out.printf("%.1f %s", number, size[i]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Число байт выходит за допустимы границы");
        }
    }
}
