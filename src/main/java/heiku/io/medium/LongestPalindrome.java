package heiku.io.medium;

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
 * @Author: Heiku
 * @Date: 2019/9/18
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()){
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = null;

        for (int i = 0; i < n; i++){
            for (int j = i; j >= 0; j--){

                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;

                    if (res == null || i - j + 1 > res.length()){
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }


    public String longestPalindrome2(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c){
                left--;
            }

            while (right < s.length() && s.charAt(right) == c){
                right++;
            }


            // is Palindrome
            while (left >= 0 && right < s.length()){
                if (s.charAt(left) != s.charAt(right))
                    break;

                left--;
                right++;
            }

            // get longest subString
            left = left + 1;
            if (end - start < right - left){
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }
}
