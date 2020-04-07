package heiku.io.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Heiku
 * @Date: 2019/8/5
 *
 * 961. N-Repeated Element in Size 2N Array
 *
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 * Example 1:
 *
 *      Input: [1,2,3,3]
 *      Output: 3
 *
 * Example 2:
 *
 *      Input: [2,1,2,5,3,2]
 *      Output: 2
 *
 * Example 3:
 *
 *      Input: [5,1,5,2,5,3,5,4]
 *      Output: 5
 *
 *
 * Note:
 *
 *      4 <= A.length <= 10000
 *      0 <= A[i] < 10000
 *      A.length is even
 */
public class RepeatedNTimes {


    // only one number repeated
    // return directly, do not count it
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            if (!set.contains(i)) {
                set.add(i);
            }else {
                return i;
            }
        }

        return 0;
    }



    // Runtime: 53 ms, faster than 5.06%   slow
    int r;
    public int repeatedNTimes2(int[] A) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else {
                int c = map.get(i);
                map.put(i, c + 1);
            }
        }

        map.forEach((k, v) -> {
            if (v == len / 2){
                r = k;
            }
        });

        return r;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,3};
        System.out.println(new RepeatedNTimes().repeatedNTimes2(A));
    }
}
