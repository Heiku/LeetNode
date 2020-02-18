package heiku.io.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class FindInArray {

    // O(N * logN), every row as a array with binarySearch
    public boolean find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++){
            int lo = 0, hi = array[i].length - 1;
            while (lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (array[i][mid] == target){
                    return true;
                }else if (array[i][mid] > target){
                    hi = mid - 1;
                }else {
                    lo = mid + 1;
                }
            }
        }
        return false;
    }

    // from the top right find,
    // if num > target, col--
    // if num < target, row++
    public boolean find2(int target, int[][] array){
        int row = 0, col = array[0].length - 1;

        while (row <= array.length - 1 && col >= 0){
            if (target == array[row][col]){
                return true;
            }
            else if (target < array[row][col]){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}