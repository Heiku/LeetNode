package heiku.io.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class Fibonacci {
    public int Fibonacci2(int n){
        if (n <= 1){
            return n;
        }
        int a = 0, b = 1;

        // simulate the calculate process
        // loop times, try take a while to consider it
        while (n-- > 1){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // bad
    public int Fibonacci3(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci3(n - 1) + Fibonacci3(n - 2);
    }
}
