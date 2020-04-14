package heiku.io.leetcode.medium;

/**
 * 6. ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 *      Input: s = "PAYPALISHIRING", numRows = 3
 *      Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *
 *      Input: s = "PAYPALISHIRING", numRows = 4
 *      Output: "PINALSIGYAHRPI"
 *      Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author Heiku
 * @date 2020/4/10
 **/
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
        int len = s.length();
        int k = 0;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        while (k < len) {
            for (int i = 0; i < numRows && k < len; i++) {
                builders[i].append(s.charAt(k++));
            }
            for (int i = numRows - 2; i > 0 && k < len; i--) {
                builders[i].append(s.charAt(k++));
            }
        }
        for (int i = 1; i < builders.length; i++){
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }

    public static void main(String[] args) {
        new ZigZagConversion().convert("PAYPALISHIRING", 3);
    }
}
