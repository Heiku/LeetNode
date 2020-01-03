package heiku.io.sort;

import java.util.Arrays;

/**
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class BinarySearch {

    public int search(int[] arr, int key){
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key == arr[mid])
                return mid;
            else if (arr[mid] < key){
                lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
        System.out.println(new BinarySearch().search(arr, 3));
    }
}
