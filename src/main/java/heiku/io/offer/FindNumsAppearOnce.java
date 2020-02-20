package heiku.io.offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
 *
 * @Author: Heiku
 * @Date: 2020/2/20
 */
public class FindNumsAppearOnce {

    // because the array just has two diff number, so when they ^（xor） each others， the left result will be the two num(xor)
    // we can get the bitResult (a ^ b)
    // secondly,  find the first 1 (idx) in binary num of bitResult,it only be influence by same idx 1 of number
    // thirdly, so we can divide the array of (same idx 1) (not same idx 1)
    // finally, we just xor each sub array, and get the two diff number.
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        if (len == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bitResult = 0;
        for (int i = 0; i < len; i++){
            bitResult ^= array[i];
        }
        int idx = findFirst1(bitResult);
        for (int i = 0; i < len; i++){
            if (isBit(array[i], idx)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult) {
        int idx = 0;
        while ((bitResult & 1) != 1 && idx < 32){
            idx++;
            bitResult >>= 1;
        }
        return idx;
    }

    private boolean isBit(int i, int idx) {
        return ((i >> idx) & 1) == 1;
    }
}
