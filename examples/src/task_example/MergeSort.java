package task_example;

public class MergeSort {
    public static int[] sort (int[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                --j;
                counter++;
            }
            array[j] = temp;
            counter++;
        }
        System.out.println(counter);
        return array;
    }
}
