package heiku.io.sort;

/**
 * loop array, record the smallest number index in array, if number bigger them it, swap them
 *
 * @Author: Heiku
 * @Date: 2019/11/13
 */
public class ChooseSort {

    public void sort(int[]arr){
        for (int i = 0; i < arr.length; i++){
            int idx = i;
            for (int j = i; j < arr.length; j++){
                if (arr[idx] > arr[j]){
                    idx = j;
                }
            }
            swap(arr, idx, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        new ChooseSort().sort(arr);

        for (int i : arr){
            System.out.println(i + " ");
        }
    }
}
