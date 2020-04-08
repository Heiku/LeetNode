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
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                // j+1 > i-1
                // consider the "bb"
                dp[j][i] = ((j + 1 > i - 1) || dp[j+1][i-1]) && s.charAt(j) == s.charAt(j);
                if (dp[j][i] && j - i + 1 > res.length()){
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++){
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i+1));
            if (cur > len){
                len = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    private int getLen(String s, int l, int r){
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("babad");
    }
}
