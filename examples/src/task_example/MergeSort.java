package task_example;

public class MergeSort {
    public static int[] sort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                --j;
            }
            array[j] = temp;
        }
        return array;
    }
}
