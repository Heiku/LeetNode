package heiku.io.easy;

import java.util.TreeMap;

/**
 * @Author: Heiku
 * @Date: 2019/9/6
 *
 * 1122. Relative Sort Array
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */
public class RelativeSortArray {

    // use array index store repeated num
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int i : arr1) {
            cnt[i]++;
        }

        // sort arr1 by arr2 num
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0){
                arr1[i++] = n;
            }
        }

        // sort without
        for (int n = 0; n < cnt.length; n++){
            while (cnt[n]-- > 0){
                arr1[i++] = n;
            }
        }

        return arr1;
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int i = 0;
        for (int n : arr2) {
            while (map.get(n) > 0){
                arr1[i++] = n;
                map.put(n, map.get(n) - 1);
            }
        }

        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;

    }
}
