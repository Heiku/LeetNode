package heiku.io.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @Author: Heiku
 * @Date: 2020/2/20
 */
public class FindNumbersWithSum {

    // two pointer (Squeeze Theorem)
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int lo = 0, hi = array.length - 1;
        while (lo < hi){
            if (array[lo] + array[hi] == sum){
                list.add(array[lo]);
                list.add(array[hi]);
                return list;
            }else if (array[lo] + array[hi] < sum){
                lo++;
            }else {
                hi--;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int []array = {1,2,4,7,11,15};
        List<Integer> list = new FindNumbersWithSum().findNumbersWithSum(array, 15);
    }
}
