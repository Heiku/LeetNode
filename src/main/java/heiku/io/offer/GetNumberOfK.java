package heiku.io.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @Author: Heiku
 * @Date: 2020/2/19
 */
public class GetNumberOfK {

    // sorted -> binarySearch
    // find the firstK and lastK
    // then the times = (lastK - firstK + 1)
    public int getNumberOfK(int [] array , int k) {
        if (array.length == 0 ){
            return 0;
        }
        int firstK = findFirstK(array, k, 0, array.length - 1);
        int lastK = findLastK(array, k, 0, array.length - 1);
        if (firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }

    private int findFirstK(int[] array, int k, int lo, int hi) {
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < k){
                lo = mid + 1;
            }else if (array[mid] > k){
                hi = mid - 1;
            }else if (mid - 1 >= 0 &&array[mid - 1] == k){
                hi = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    private int findLastK(int[] array, int k, int lo, int hi){
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < k){
                lo = mid + 1;
            }else if (array[mid] > k){
                hi = mid - 1;
            }else if (mid + 1 <= hi && array[mid + 1] == k){
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
