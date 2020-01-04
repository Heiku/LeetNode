package heiku.io.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。(算法稳定性)
 * [奇，偶]
 *
 * @Author: Heiku
 * @Date: 2020/1/4
 */
public class ReOrderArray {

    public void reOrderArray(int [] array) {
        for (int i = 1; i < array.length; i++){
            int tmp = array[i];
            if (tmp % 2 == 1){
                for (int j = i; j > 0; j--){
                    if (array[j - 1] % 2 == 0){
                        swap(array, i, j - 1);
                    }
                }
            }
        }
    }


    // bubble
    public void reOrderArray2(int [] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = array.length - 1; j > i; j--){
                if (array[j] % 2 == 1 && array[j - 1] % 2 ==0){
                    swap(array, j , j - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int lo, int hi){
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};        // [1, 3, 5, 7, 2, 4, 6]
        new ReOrderArray().reOrderArray(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }
}
