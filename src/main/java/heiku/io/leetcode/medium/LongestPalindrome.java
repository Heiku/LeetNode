package heiku.io.leetcode.medium;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 *      Input: "babad"
 *      Output: "bab"
 *      Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 *      Input: "cbbd"
 *      Output: "bb"
 *
 *
 * solution:
 *
 *  e a b c b a d       on center
 *  e a b c c b a d     two center
 *
 *  if s[i ~ j] is a palindrome, s[i+1 ~ j-1] is also one.
 *  if s[i ~ j] is not a palindrome, s[i-1 ~ j+1] can not be a palindrome.
 *
 *
 *  Instead of starting from two sides, we can start from the center.
 *  For each index i, or pair (i, i+1) we take it as the middle elements and expand towards two end to find the longest
 *  palindrome.
 *
 *  if dp[l+1][r-1] (the inside one is palindrome) and s[l] == s[r]  -> dp[l][r] = true
 *
 *  best O(n) -> worst  O(n^2)
 *
 * @Author: Heiku
 * @Date: 2019/9/18
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        
    }


    public String longestPalindrome2(String s) {

    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("babad");
    }
}
