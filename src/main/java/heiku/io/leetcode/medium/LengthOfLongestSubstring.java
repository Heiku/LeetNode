package heiku.io.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 *      Example 1:
 *
 *      Input: "abcabcbb"
 *      Output: 3
 *      Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Example 2:
 *
 *      Input: "bbbbb"
 *      Output: 1
 *      Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *      Input: "pwwkew"
 *      Output: 3
 *      Explanation: The answer is "wke", with the length of 3.
 *
 *
 *      Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @Author: Heiku
 * @Date: 2019/9/16
 */
public class LengthOfLongestSubstring {

    // slide window
    // substring, it means it is continuous
    // maintain two var record window's left and  right
    // loop string and update right index, and cal the max length of window
    //      when meet char in string, update left index of window
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(s.charAt(i))){
                // if not get the max value of left index, the new substring will be replaced
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("adbccba"));
    }
}
