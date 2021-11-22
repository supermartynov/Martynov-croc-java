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
        SliyanieSort.mergeSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
