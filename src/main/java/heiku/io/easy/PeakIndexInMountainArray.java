package heiku.io.easy;

/**
 * @Author: Heiku
 * @Date: 2019/8/12
 *
 * 852. Peak Index in a Mountain Array
 *
 *
 * Let's call an array A a mountain if the following properties hold:
 *
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 *
 *
 *
 * Example 1:
 *
 *      Input: [0,1,0]
 *      Output: 1
 *
 * Example 2:
 *
 *      Input: [0,2,1,0]
 *      Output: 1
 *
 */
public class PeakIndexInMountainArray {

    // Binary Search
    // O(logN)
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1]){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }



    // O(n) straight forward
    public int peakIndexInMountainArray2(int[] A) {
        int len = A.length;
        int d = 0;

        int half = len / 2;
        for (int i = 1; i < len; i++){
            if (d <= half && A[i - 1] < A[i]){
                d++;
            }
        }

        return d;
    }
}
