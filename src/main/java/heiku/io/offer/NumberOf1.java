package heiku.io.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class NumberOf1 {
    public int numberOf1(int n) {
        int s = 0;
        while (n != 0){
            s++;

            // 1100 & (1011) = 1000 retain the 1 in number
            n = n & (n -1);     // （n - 1）to remove the right 1 of number
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1(5));
    }
}
