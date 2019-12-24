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

    public void sort(int[] a, int lo, int hi){
        if (lo >= hi)
            return;

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        int v = a[lo];

        while (true){
            while (a[++i] < v){
                if (i >= hi)
                    break;
            }
            while (a[--j] > v){
                if (j <= lo)
                    break;
            }
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public void swap(int[] a, int i, int j){
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
