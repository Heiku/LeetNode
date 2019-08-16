package heiku.io.easy;

import java.util.*;

/**
 *
 * 590. N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *
 *
 * https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png  [postorder]
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 *
 * @Author: Heiku
 * @Date: 2019/8/16
 */
public class Postorder {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null){
            return list;
        }

        root.children.forEach(n -> postorder(n));

        list.add(root.val);

        return list;
    }


    // Runtime: 4 ms, faster than 32.56%
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            List<Node> childs = root.children;
            for (Node child : childs) {
                stack.push(child);
            }
        }
        Collections.reverse(list);
        return list;
    }

}
