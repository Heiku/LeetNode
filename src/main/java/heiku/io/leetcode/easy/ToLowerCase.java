package heiku.io.leetcode.easy;

/**
 * @Author: Heiku
 * @Date: 2019/8/3
 *
 * 709. To Lower Case
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 *
 *      Input: "Hello"
 *      Output: "hello"
 *
 * Example 2:
 *
 *      Input: "here"
 *      Output: "here"
 *
 * Example 3:
 *
 *      Input: "LOVELY"
 *      Output: "lovely"
 *
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] arr= str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char) (arr[i] + 'a' - 'A');
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        new ToLowerCase().toLowerCase("Hello");
    }
}
