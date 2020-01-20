package heiku.io.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * @Author: Heiku
 * @Date: 2020/1/20
 */
public class IsPopOrder {

    // 1,2,3,4,5    4,3,5,1,2
    public boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;

        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int value : pushA) {
            stack.push(value);

            while (!stack.empty() && stack.peek() == popA[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        // if is popOrder, the stack will be empty
        return stack.empty();
    }
}
