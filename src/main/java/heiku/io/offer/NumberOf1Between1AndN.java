package heiku.io.offer;

/**
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6?f=discussion
 *
 * @Author: Heiku
 * @Date: 2020/2/18
 */
public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN(int n) {
        if (n < 1)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp;
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
        int otherOneNUm = first * (len - 1) * (tmp / 10);
        return firstOneNum + otherOneNUm + numberOf1Between1AndN(n % tmp);
    }

    private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
