package heiku.io.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Heiku
 * @Date: 2019/8/6
 *
 * 657. Robot Return to Origin
 *
 * There is a robot starting at position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i] represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down).
 * If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once,
 * "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 * Example 1:
 *
 *      Input: "UD"
 *      Output: true
 *      Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
 *      so it ended up at the origin where it started. Therefore, we return true.
 *
 *
 * Example 2:
 *
 *      Input: "LL"
 *      Output: false
 *      Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
 *      We return false because it is not at the origin at the end of its moves.
 *
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        if (moves == null){
            return false;
        }

        int U = 0;
        int D = 0;
        int L = 0;
        int R = 0;

        char[] cArr = moves.toCharArray();

        for (char c : cArr) {
            if (c == 'U'){
                U++;
            } else if (c == 'D'){
                D++;
            } else if (c == 'L'){
                L++;
            } else if(c == 'R'){
                R++;
            }
        }
        if (L - R == 0 && U - D == 0){
            return true;
        }
        return false;
    }


    // slow solution
    // Runtime: 28 ms, faster than 5.45%
    public boolean judgeCircle2(String moves) {
        List<Character> cList = new ArrayList<>();

        char[] cArr = moves.toCharArray();
        for (char c : cArr) {
            if (c == 'U'){
                if (cList.contains('D')){
                    cList.remove(new Character('D'));
                }else {
                    cList.add(c);
                }
            }else if (c == 'D'){
                if (cList.contains('U')){
                    cList.remove(new Character('U'));
                }else {
                    cList.add(c);
                }
            }else if (c == 'L'){
                if (cList.contains('R')){
                    cList.remove(new Character('R'));
                }else {
                    cList.add(c);
                }
            }else if (c == 'R'){
                if (cList.contains('L')){
                    cList.remove(new Character('L'));
                }else {
                    cList.add(c);
                }
            }
        }

        return cList.isEmpty();
    }

    public static void main(String[] args) {
        new JudgeCircle().judgeCircle("UD");
    }
}
