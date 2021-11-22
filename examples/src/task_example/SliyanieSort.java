package task_example;

import java.util.Arrays;

public class SliyanieSort {
    public static void mergeSort(int[] array) {

        if (array.length < 2) {
            return;
        }

        int delimiter = (array.length / 2);
        int[] left = new int[array.length/2];
        int[] right = new int[array.length - left.length];

        for (int i = 0; i < delimiter; i++) {
            left[i] = array[i];
        }

        for (int i = delimiter; i < array.length; i++) {
            right[i - delimiter] = array[i];
        }

        mergeSort(left);
        mergeSort(right);
        recurtionMergeSort(array, left, right);
    }


    public static void recurtionMergeSort(int[] targetArray, int[] array1, int[] array2) {
        int array1MinIndex = 0;
        int array2MinIndex = 0;
        int targetArrayMinIndex = 0; //адресс ячейки, в которую послед минимальный элемент будет помещаться

        while (array1MinIndex < array1.length && array2MinIndex < array2.length) {
            if (array1[array1MinIndex] <= array2[array2MinIndex]) {
                targetArray[targetArrayMinIndex] = array1[array1MinIndex];
                array1MinIndex++;
            } else if (array1[array1MinIndex] > array2[array2MinIndex]) {
                targetArray[targetArrayMinIndex] = array2[array2MinIndex];
                array2MinIndex++;
            }
            targetArrayMinIndex++;
        }

        while (array1MinIndex < array1.length) {
            targetArray[targetArrayMinIndex] = array1[array1MinIndex];
            targetArrayMinIndex++;
            array1MinIndex++;
        }

        while (array2MinIndex < array2.length) {
            targetArray[targetArrayMinIndex] = array2[array2MinIndex];
            targetArrayMinIndex++;
            array2MinIndex++;
        }

    }
}
