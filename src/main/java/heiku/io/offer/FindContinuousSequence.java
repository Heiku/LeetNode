package heiku.io.offer;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列
 * 如 100 (9, 10, 11, 12, 13, 14, 15, 16) (18, 19, 20, 21, 22)
 *
 * @Author: Heiku
 * @Date: 2020/2/20
 */
public class FindContinuousSequence {

    // slice windows
    // when use Sn() get the sum of slice windows
    // them foreach the numbers of windows and offer in list
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        int lo = 1, hi = 2;
        while (lo < hi){
            // S(n) = (a1 + an) * n / 2
            int cur = (lo + hi) * (hi - lo + 1) / 2;
            if (cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = lo; i <= hi; i++){
                    list.add(i);
                }
                resultList.add(list);
                lo++;
            }else if (cur < sum){
                hi++;
            }else{
                lo++;
            }
        }
        return resultList;
    }
}
