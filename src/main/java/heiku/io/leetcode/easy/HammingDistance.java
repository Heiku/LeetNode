package heiku.io.leetcode.easy;

/**
 * @Author: Heiku
 * @Date: 2019/8/9
 *
 * 461. Hamming Distance
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {


    // is same with third, diff is between loop xor >>= 1 and  loop xor >>= i
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++){
            count += xor & 1;
            xor >>= 1;

        }
        return count;
    }


    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }

        return count;
    }


    // use java utils
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        new HammingDistance().hammingDistance(1,4);
    }
}
