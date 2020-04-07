package heiku.io.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Heiku
 * @Date: 2019/8/7
 *
 * 728. Self Dividing Numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example 1:
 *      Input:  left = 1, right = 22
 *      Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class SelfDividingNumbers {


    // loop / self
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfList = new ArrayList<>();

        for (int i = left; i <= right; i++){
            int j = i;
            for (; j > 0; j /= 10){
                if (j % 10 == 0 || i % (j % 10) != 0)
                    break;

                if (j == 0) {
                    selfList.add(j);
                }
            }

        }
        return selfList;
    }

    public static void main(String[] args) {
        new SelfDividingNumbers().selfDividingNumbers(1,22);

        System.out.println(2 % 10);
    }
}
