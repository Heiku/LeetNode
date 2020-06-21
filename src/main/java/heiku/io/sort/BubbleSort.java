package heiku.io.sort;

import java.util.Arrays;

/**
 * compare two value and swap the location, after the once loop, the max value is the last of array
 * see https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class BubbleSort {

    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // arr.length - i, the last number of i is sorted
            for (int j = 1; j < arr.length; j++){
                if (arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        new BubbleSort().sort(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }
}
