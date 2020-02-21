package heiku.io.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class Sum {
    // use recursive instead of loop
    // use &&        instead of if
    public int sum(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }
}
