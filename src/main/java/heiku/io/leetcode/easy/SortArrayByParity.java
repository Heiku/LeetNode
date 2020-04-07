package heiku.io.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Heiku
 * @Date: 2019/8/4
 *
 * 905. Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 *      Input: [3,1,2,4]
 *      Output: [2,4,3,1]
 *
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {


    // O(n)
    // loop i record even
    // swap the value start the head of array
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                int tmp = A[j];
                A[j++] = A[i];
                A[i] = tmp;
            }
        }
        return A;
    }



    // use collection
    // bad speed test : 2ms 17%
    public int[] sortArrayByParity2(int[] A) {
        List<Integer> evenArr = new ArrayList<>();
        List<Integer> oddArr = new ArrayList<>();

        for (int i : A) {
            if (i % 2 == 0){
                evenArr.add(i);
            }else {
                oddArr.add(i);
            }
        }

        evenArr.addAll(oddArr);
        A = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = evenArr.get(i);
        }
        return A;
    }


    public static void main(String[] args) {
        int[] arr= new int[]{0, 2};
        new SortArrayByParity().sortArrayByParity(arr);
    }
}
