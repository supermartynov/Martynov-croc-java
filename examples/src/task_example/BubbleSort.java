package task_example;

public class BubbleSort {

    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        int buf;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    counter++;
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                    isSorted = false;
                }
            }
        }
        System.out.println(counter);
        return arr;
    }
}
