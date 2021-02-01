package heiku.io.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * QuickSort
 * <p>
 * before starting write quickSort, you may think about quick sort moving status, if feel confuse,
 * see https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html, and try to write by yourself
 *
 * @Author: Heiku
 * @Date: 2019/11/13
 */
public class QuickSort {

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(arr, lo, hi);
        sort(arr, lo, mid - 1);
        sort(arr, mid + 1, hi);
    }

    private static int partition(int[]arr, int lo, int hi) {
        int i = lo, j = hi, v = arr[lo];
        while (true) {
            while (arr[i] <= v && i < hi) {
                i++;
            }
            while (arr[j] > v && j > lo) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
        }
        QuickSort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
