package heiku.io.sort;

import java.util.Arrays;

/**
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class MergeSort {

    public void mergeSort(int[] arr, int lo, int hi){
        if (lo >= hi)
            return;

        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid - 1);
        mergeSort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);
    }

    public void merge(int[] arr, int lo, int mid, int hi){
        // sort in duplicate array
        int[] aux = Arrays.copyOfRange(arr, lo, hi + 1);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                arr[k] = aux[j - lo];
                j++;
            }
            else if (j > hi){
                arr[k] = aux[i - lo];
                i++;
            }
            else if (aux[i - lo] < aux[j - lo]){
                arr[k] = aux[i - lo];
                i++;
            }else {
                arr[k] = aux[j - lo];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        new MergeSort().mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }
}
