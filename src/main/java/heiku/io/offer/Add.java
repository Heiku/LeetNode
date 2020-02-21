package heiku.io.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class Add {
    // xor make sure the number every idx is 1
    // 5(101) 7(111)
    // ^ 101
    //   111
    //   010

    // & << 1 remove the same indx 1
    // & 101
    //   111 << 1
    //  1010
    public int add(int num1,int num2) {
        while (num2 != 0){
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }

}
