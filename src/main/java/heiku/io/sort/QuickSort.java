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

    public static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi, v = arr[lo];
        while (true) {
            while (i < hi && arr[i] <= v) {
                i++;
            }
            while (j > lo && arr[j] >= v) {
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

    public static void swap(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
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
