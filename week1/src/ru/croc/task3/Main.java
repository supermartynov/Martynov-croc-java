package ru.croc.task3;

import java.util.Scanner;

public class Main {

    static int[] intArr;

    static void fillArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String[] stringNumbers = scanner.nextLine().trim().split(" ");
        intArr = new int[stringNumbers.length];

        int i = 0;
        for (String str:stringNumbers) {
            intArr[i++] = Integer.parseInt(str);
        }
    }

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
        int length = intArr.length;
        int[] arr = maxMin(intArr);
        int min = arr[0];  //индекс минимального элемента
        int max = arr[1];  //индекс максимального элемента

        if (min - max == 1 && max == 0) {    //меняем местами минимальный и максимальный элемент, если максимальный стоит
            int minValue = intArr[min];      //в начале массива и максимальный на одну позицию левее минимального.
            intArr[min] = intArr[max];
            intArr[max] = minValue;
            max++;
            min--;
        }

        if (min == intArr.length - 1 && max == 0) { //если минимальный элемент стоит в конце,
            int tmp = intArr[min];                  //а максимальный в начале, то меняем их местами и заканчиваем
            intArr[min] = intArr[max];
            intArr[max] = tmp;
            return;
        }

        if (min == 0 && max == intArr.length - 1) { //если все на своих местах, то ничего не меняем и заканчиваем
            return;
        }

        int firstElementInArray = intArr[0];  //меняем минимальный элемент местами с тем,
        intArr[0] = intArr[min];              //который стоял на первой позиции массива
        intArr[min] = firstElementInArray;

        int lastElementInArray = intArr[length - 1]; //меняем максимальный элемент местами с тем,
        intArr[length - 1] = intArr[max];            // который стоял на последней позиции
        intArr[max] = lastElementInArray;
    }

    static void prinArray() {
        for (int j = 0; j < intArr.length; j++) {
            System.out.print(intArr[j] + " ");
        }
    }

    public static void main(String[] args) {

        fillArrayFromConsole(); //метод считывающий элементы массива с консоли
        swap(); //метод, выполняющий перестановку
        prinArray(); //печатаем
    }
}
