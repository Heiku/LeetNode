package heiku.io.sort;

/**
 * @Author: Heiku
 * @Date: 2019/11/15
 */
public class InsertSort {

    private void sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j > 0; j--){
                if (arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,6,4,8,2};
        new InsertSort().sort(arr);

        for (int i : arr){
            System.out.println(i + " ");
        }
    }
}
