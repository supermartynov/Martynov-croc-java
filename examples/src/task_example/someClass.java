package task_example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class someClass {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 7, 1, 5};
        //BubbleSort.sort(arr);
        //InsertionSort.sort(arr);
        //SliyanieSort.mergeSort(arr);
        QuickSort.quickSort(arr, 0, arr.length - 1);
        int a = BinarySearch.binarySearch(arr, 2);
        System.out.println(a);

        Thread thread = new Thread(() -> System.out.println("аа"));
        thread.start();
        System.out.println(Arrays.toString(arr));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("lala");
            }
        };

    }
}
