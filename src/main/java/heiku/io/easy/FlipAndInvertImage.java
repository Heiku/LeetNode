package heiku.io.easy;

import java.util.Stack;

/**
 * @Author: Heiku
 * @Date: 2019/8/3
 *
 * 832. Flipping an Image
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 *      Input: [[1,1,0],[1,0,1],[0,0,0]]
 *      Output: [[1,0,0],[0,1,0],[1,1,1]]
 *      Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 *      Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Example 2:
 *
 *      Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 *      Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *      Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 *      Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 */
public class FlipAndInvertImage {

    // binary loop update all arr
    // if head == tail, them head = tail = 1 ^ head
    // if head != tail, do not deal it
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++){
            int lo = 0, hi = A[0].length - 1;
            while (lo <= hi){
                if (A[i][lo] == A[i][hi]){
                    A[i][lo] = 1 - A[i][lo];
                    A[i][hi] = A[i][lo];
                }
                lo++;
                hi--;
            }
        }
        return A;
    }


    // deal with stack
    public int[][] flipAndInvertImage2(int[][] A) {
        for (int i = 0; i < A.length; i++){
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < A[0].length; j++){
                stack.add(A[i][j]);
            }
            for (int j = 0; j < A[0].length; j++){
                int k = stack.pop();
                A[i][j] = 1- k;
            }
        }
        return A;
    }
}
