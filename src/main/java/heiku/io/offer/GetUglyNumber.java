package heiku.io.offer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @Author: Heiku
 * @Date: 2020/2/18
 */
public class GetUglyNumber {

    // direct calculate the front index of uglyNumber
    // p(n) = 2*t2 + 3*t3 + 5*t5
    // 2*1  3*1  5*1
    // 2*2  3*1  5*1
    // 2*2  3*2  5*1
    // 2*3  3*2  5*1
    // 2*3  3*2  5*2
    // 2*4  3*3  5*2
    // 2*5  3*3  5*2
    // 2*5  3*4  5*2
    // 2*6  3*4  5*3
    // 2*8  3*5  5*3
    // 2*8  3*6  5*4
    public int getUglyNumber(int index){
        if (index < 7){
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++){
            arr[i] = Math.min(arr[t2] * 2, Math.min(arr[t3] * 3 , arr[t5] * 5));
            if (arr[i] == arr[t2] * 2){
                t2++;
            }
            if (arr[i] == arr[t3] * 3){
                t3++;
            }
            if (arr[i] == arr[t5] * 5){
                t5++;
            }
        }
        return arr[index - 1];
    }

    // out of time
    public int getUglyNumber2(int index) {
        if (index < 7){
            return index;
        }

        int count = 0, i;
        for (i = 1; count != index; i++){
            if (isUnglyNum(i)){
                count++;
            }
        }
        return i - 1;
    }

    public boolean isUnglyNum(int i){
        int tmp = i;
        while (tmp % 2 == 0){
            tmp /= 2;
        }
        while (tmp % 3 == 0){
            tmp /= 3;
        }
        while (tmp % 5 == 0){
            tmp /= 5;
        }
        if (tmp == 1){
            return true;
        }
        return false;
    }
}
