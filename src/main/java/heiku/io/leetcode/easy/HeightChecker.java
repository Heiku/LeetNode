package heiku.io.leetcode.easy;

import java.util.Arrays;

/**
 * 1051. Height Checker
 *
 * tudents are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students not standing in the right positions.
 * (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 *
 *
 *
 * Example 1:
 *
 *      Input: [1,1,4,2,1,3]
 *      Output: 3
 *
 * Explanation:
 *      Students with heights 4, 3 and the last 1 are not standing in the right positions.
 *
 *
 * @Author: Heiku
 * @Date: 2019/8/14
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for(int i = 0; i < copy.length; i++){
            if(heights[i]!=copy[i])count++;
        }
        return count;
    }
}
