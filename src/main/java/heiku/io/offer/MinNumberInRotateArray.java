package heiku.io.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class MinNumberInRotateArray {

    // binarySearch
    public int minNumberInRotateArray(int [] array) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if (array[mid] > array[hi]){
                lo = mid + 1;       // the smallest num must be right side [3, 4, 5, 1, 2]
            }else if (array[mid] < array[hi]){
                hi = mid;       // the smallest num be left side,but maybe current is the low one [5, 1, 2, 3, 4]
            }else {
                hi = hi - 1;
            }
        }
        return array[lo];
    }

    public static void main(String[] args) {
        //int[]arr = {3, 4, 5, 1, 2};
        int[]arr = {2, 3, 4, 5, 1};
        System.out.println(new MinNumberInRotateArray().minNumberInRotateArray(arr));
    }
}
