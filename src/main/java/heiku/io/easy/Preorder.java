package heiku.io.easy;

import java.util.*;

/**
 * 589. N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 * @Author: Heiku
 * @Date: 2019/8/15
 */
public class Preorder {

    //Runtime: 1 ms, faster than 100.00%
    // iteratively
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null){
            return res;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }

    // Runtime: 4 ms, faster than 16.62%
    // Recursive  with stack
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){
            root = stack.pop();

            List<Node> child = root.children;
            for (int i = child.size() - 1; i >= 0; i--) {
                stack.push(child.get(i));
            }
            res.add(root.val);
        }

        return res;
    }
}
