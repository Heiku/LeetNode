package heiku.io.leetcode.easy;

/**
 * 922. Sort Array By Parity II
 *
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 *      Input: [4,2,5,7]
 *      Output: [4,5,2,7]
 *
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 *
 * @Author: Heiku
 * @Date: 2019/8/20
 */
public class SortArrayByParityII {

    // O(n)
    // use other array to store the value
    // loop the old arr and change the index of odd or even on new arr
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int j = 0, k = 1;
        for (int i = 0; i < A.length; i++){
            if (A[i] % 2 == 0){
                res[j] = A[i];
                j += 2;
            }else {
                res[k] = A[i];
                k += 2;
            }
        }
        return res;
    }
}
