package heiku.io.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 *
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @Author: Heiku
 * @Date: 2020/1/10
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0){
            return null;
        }

        int startRow = 0, endRow = row - 1;
        int startCol = 0, endCol = col - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // just left one row
            if (startRow == endRow){
                for (int i = startCol; i <= endCol; i++) {
                    list.add(matrix[startRow][i]);
                }
                return list;
            }
            // just left one col
            if (startCol == endCol){
                for (int i = startRow; i <= endRow; i++) {
                    list.add(matrix[i][startCol]);
                }
                return list;
            }

            for (int i = startCol; i <= endCol; i++){
                list.add(matrix[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }
            for (int i = endCol - 1; i >= startCol; i--){
                list.add(matrix[endRow][i]);
            }
            for (int i = endRow - 1; i >= startRow + 1; i--){
                list.add(matrix[i][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
        return list;
    }
}
