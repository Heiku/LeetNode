package heiku.io.classic;

import java.util.Random;

/**
 * 给定一个数据流，数据流长度 N 很大，且 N 直到处理完所有数据之前都不可知，
 * 请问如何在只遍历一遍数据（O(N)）的情况下，能够随机选取出m个不重复的数据。
 *
 * 1. 数据流长度为 N 很大且不可知，所以不能一次性存入内存
 * 2. 时间复杂度为 O(N)
 * 3. 随机选取 m 个数，每个数被选中的概率为 m/N
 *
 *
 * @Author: Heiku
 * @Date: 2020/1/10
 */
public class ReservoirSampling {

    private Random rand = new Random();

    public void sampling(int m, int[] dataStream){
        int[] reservoir = new int[m];

        for (int i = 0; i < reservoir.length; i++){
            reservoir[i] = dataStream[i];
        }

        // make sure the reservoir always m/N
        for (int i = m; i < dataStream.length; i++){
            int d = rand.nextInt(i + 1);
            if (d < m){
                reservoir[d] = dataStream[i];
            }
        }
    }
}
