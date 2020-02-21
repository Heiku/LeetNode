package heiku.io.offer;

/**
 * https://uploadfiles.nowcoder.com/images/20160829/841505_1472459965615_8640A8F86FB2AB3117629E2456D8C652
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
 *
 * // every row B[i] = A[0] * ... * A[n - 1]  except A[i]
 * B[0]
 * B[1]
 * B[2]
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len != 0){
            B[0] = 1;
            for (int i = 1; i < len; i++){
                B[i] = B[i - 1] * A[i - 1];
            }
            int tmp = 1;
            for (int j = len - 2; j >= 0; j--){
                tmp *= A[j + 1];
                B[j] *= tmp;
            }
        }
        return B;
    }
}
