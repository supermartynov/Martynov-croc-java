package ru.croc.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String stringNumber = scanner.nextLine();

        if (stringNumber.length() < 10) {
            double number = Double.parseDouble(stringNumber);
            if (number < 1024) {
                System.out.print(number + " B");
            } else if (number < 1024 * 1024) {
                System.out.printf("%.1f KB", number / 1024);
            } else if (number < 1024 * 1024 * 1024 ) {
                System.out.printf("%.1f MB", number / (1024 * 1024));
            }
        } else {
            float number = Float.parseFloat(stringNumber);
            if (number < 1024L * 1024 * 1024 * 1024) {
                System.out.printf("%.1f GB", number / (1024 * 1024 * 1024));
            } else if (number < 1024L * 1024 * 1024 * 1024 * 1024) {
                System.out.printf("%.1f TB", number / (1024L * 1024 * 1024 * 1024));
            }
        }
    }
}
