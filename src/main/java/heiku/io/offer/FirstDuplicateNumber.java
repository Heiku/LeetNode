package heiku.io.offer;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class FirstDuplicateNumber {

    // use array store the status of numbers[] element(number)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0){
            duplication[0] = -1;
            return false;
        }
        boolean[] arr = new boolean[length];
        for (int i = 0; i < numbers.length; i++){
            if (arr[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }
            arr[numbers[i]] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 1, 4};
        new FirstDuplicateNumber().duplicate(numbers, numbers.length, new int[1]);
    }
}
