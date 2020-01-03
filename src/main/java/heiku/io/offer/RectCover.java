package heiku.io.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * see https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6?f=discussion
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class RectCover {
    // fib()
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
