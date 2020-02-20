package heiku.io.offer;

/**
 * (XY question)
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @Author: Heiku
 * @Date: 2020/2/20
 */
public class LeftRotateString {
    public String leftRotateString(String str,int n) {
        if (str == null || str.isEmpty()){
            return "";
        }
        char[] chars = str.toCharArray();

        // swap (0, n- 1)  || swap(n, len - 1)
        //          swap(0, len - 1)
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end){
        while (start <= end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new LeftRotateString().leftRotateString("abcdefg", 2);
    }
}
