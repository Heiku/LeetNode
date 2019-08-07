package heiku.io.easy;

import java.util.Arrays;

/**
 * @Author: Heiku
 * @Date: 2019/8/7
 *
 * 977. Squares of a Sorted Array
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 *      Input: [-4,-1,0,3,10]
 *      Output: [0,1,9,16,100]
 *
 * Example 2:
 *
 *      Input: [-7,-3,2,3,11]
 *      Output: [4,9,9,49,121]
 *
 */
public class SortedSquares {


    // two pointer
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];

        int head = 0;
        int tail = A.length - 1;

        for (int i = tail; i >= 0; i--){

            if (Math.abs(A[tail]) > Math.abs(A[head])){
                B[i] = A[tail] * A[tail];
                tail--;
            }else {
                B[i] = A[head] * A[head];
                head++;
            }
        }
        return B;
    }


    // stream solution, slow but cool
    // Runtime: 52 ms, faster than 6.60%
    public int[] sortedSquares3(int[] A){
        return Arrays.stream(A)
                .boxed()
                .sorted((o1, o2) -> Integer.compare(Math.abs(o1), Math.abs(o2)))
                .map(x -> Math.pow(x, 2))
                .mapToInt(i -> i.intValue())
                .toArray();
    }

    // common solution
    // Runtime: 3 ms, faster than 32.84%
    public int[] c2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0){
                A[i] = -A[i];
            }
        }
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        return A;
    }
}
