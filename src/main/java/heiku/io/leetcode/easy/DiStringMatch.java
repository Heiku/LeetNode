package heiku.io.leetcode.easy;

/**
 * 942. DI String Match
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 *
 * Example 1:
 *
 *      Input: "IDID"
 *      Output: [0,4,1,3,2]
 *
 * Example 2:
 *
 *      Input: "III"
 *      Output: [0,1,2,3]
 *
 * Example 3:
 *
 *      Input: "DDI"
 *      Output: [3,2,0,1]
 *
 * @Author: Heiku
 * @Date: 2019/8/13
 */
public class DiStringMatch {

    // straight forward find
    // when meet D, fill the array with max--
    // when meet I. fill the array with min++
    // when pointer arrive the last, judge the last character of the Str,
    public int[] diStringMatch(String S) {
        int len = S.length() + 1;
        int[] A = new int[len];

        int max = S.length();
        int min = 0;
        char[] C = S.toCharArray();
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 'D'){
                A[i] = max--;
                if (i == C.length - 1){
                    A[i+1] = min;
                }
            }else{
                A[i] = min++;
                if (i == C.length - 1){
                    A[i+1] = max;
                }
            }
        }
        return A;
    }
}
