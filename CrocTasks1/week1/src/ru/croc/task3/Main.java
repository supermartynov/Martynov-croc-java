package ru.croc.task3;

import java.util.Scanner;

public class Main {

    static int[] intArr;

    static int[] maxMin(int[] arr) {

        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }

            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return new int[] {minIndex, maxIndex};
    }

    static void swap() {
        int[] arr = maxMin(intArr);
        int min = arr[0];
        int max = arr[1];
        int tmpValue = intArr[0];

        if (min == intArr.length - 1 && max == 0) {
            int tmp = intArr[min];
            intArr[min] = intArr[max];
            intArr[max] = tmp;
            return;
        }

        intArr[0] = intArr[min];
        intArr[min] = tmpValue;
        tmpValue = intArr[intArr.length - 1];
        intArr[intArr.length - 1] = intArr[max];
        intArr[max] = tmpValue;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] stringNumbers = scanner.nextLine().trim().split(" ");
        intArr = new int[stringNumbers.length];

        int i = 0;
        for (String str:stringNumbers) {
            intArr[i++] = Integer.parseInt(str);
        }

        swap();

        for (int j = 0; j < intArr.length; j++) {
            System.out.print(intArr[j] + " ");
        }
    }
}
