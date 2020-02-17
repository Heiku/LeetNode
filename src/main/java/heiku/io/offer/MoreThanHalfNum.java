package heiku.io.offer;

import java.util.Arrays;

/**
 * (Solider Question)
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @Author: Heiku
 * @Date: 2020/2/17
 */
public class MoreThanHalfNum {

    public int moreThanHalfNum(int[] array){
        if (array.length <= 0){
            return 0;
        }

        int num = array[0];
        int count = 1;

        // find the most appear num in array,
        for (int i = 1; i < array.length; i++){
            if (array[i] == num){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                num = array[i];
                count = 1;
            }
        }

        // verify again, because it may not be more than half num
        count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == num){
                count++;
            }
        }

        if (count > array.length / 2){
            return num;
        }
        return 0;
    }

    // O(NLogN)
    // sort the array, the middle number is the need num
    public int moreThanHalfNum2(int [] array) {
        if (array.length <= 0){
            return 0;
        }
        Arrays.sort(array);
        int n = array[array.length / 2];

        for (int i = 0; i < array.length; i++){
            int count = 0;
            if (array[i] == n){
                count++;
            }
            if (count > array.length / 2){
                return n;
            }
        }
        return 0;
    }
}
