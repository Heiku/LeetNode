package heiku.io.easy;

/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 * Example 1:
 *
 *      Input: 2
 *      Output: 1
 *      Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 *
 *      Input: 3
 *      Output: 2
 *      Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 *
 *      Input: 4
 *      Output: 3
 *      Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * @Author: Heiku
 * @Date: 2019/8/21
 */
public class Fib {

    /**
     *  Iterative
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     */
    public int fib(int N) {
        if (N <= 1){
            return N;
        }

        int a = 0, b = 1;

        // loop times, try take a while to consider it
        while (N-- > 1){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }


    /**
     * Dynamic Programming - Top Down Approach
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     */
    int[] fib_cache = new int[31];
    public int fib2(int N) {
        if(N <= 1)
            return N;
        else if(fib_cache[N] != 0)
            return fib_cache[N];
        else
            return fib_cache[N] = fib2(N - 1) + fib2(N - 2);
    }

    /**
     * Time complexity: O(2^n)- since T(n) = T(n-1) + T(n-2)is an exponential time
     * Space complexity: O(n) - space for recursive function call stack
     *
     * Runtime: 9 ms, faster than 24.63%  Recursive
     */
    public int fib4(int N) {
        if (N == 0){
            return 0;
        }
        if (N == 1){
            return 1;
        }
        return fib4(N - 1) + fib4(N - 2);
    }
}
