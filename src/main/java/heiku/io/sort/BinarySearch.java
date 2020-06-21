package heiku.io.sort;

import java.util.Arrays;

/**
 * BinarySearch
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class BinarySearch {

    public static int search(int[] arr, int key){
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > key) {
                hi = mid - 1;
            }else if (arr[mid] < key) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
        System.out.println();
        System.out.println(BinarySearch.search(arr, 6));
    }
}
