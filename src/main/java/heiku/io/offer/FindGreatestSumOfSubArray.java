package heiku.io.offer;

/**
 * DP
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
 *
 * @Author: Heiku
 * @Date: 2020/2/18
 */
public class FindGreatestSumOfSubArray {

    // F(i) = max(F(i - 1) + array[], array[i])
    public int findGreatestSumOfSubArray(int[] array) {
        int res = array[0];     // record the max value
        int fi = array[0];      // F(i)
        for (int i = 1; i < array.length; i++){
            fi = Math.max(fi + array[i], array[i]);
            res = Math.max(fi, res);
        }
        return res;
    }
}
