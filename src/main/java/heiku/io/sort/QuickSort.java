package heiku.io.sort;

import java.util.Arrays;

/**
 * before starting write quickSort, you may think about quick sort moving status, if feel confuse,
 * see https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html, and try to write by yourself
 *
 * @Author: Heiku
 * @Date: 2019/11/13
 */
public class QuickSort {

    public void sort(int[] arr, int lo, int hi){
        if (lo >= hi)
            return;

        int j = partition(arr, lo, hi);
        sort(arr, lo, j);
        sort(arr, j + 1, hi);
    }

    public int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = arr[lo];

        while (true) {
            while (arr[++i] <= v && i < hi) {

            }
            while (arr[--j] >= v && j > lo) {

            }

            if (i >= j)
                break;

            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        new QuickSort().sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
}
