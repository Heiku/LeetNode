package heiku.io.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class JumpFloor {

    // same with Fib
    public int JumpFloor(int target) {
        if (target < 2){
            return target;
        }
        int a = 0, b = 1;
        while (target-- > 0){
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
