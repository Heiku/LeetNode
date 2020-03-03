package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 *
 * @Author: Heiku
 * @Date: 2020/3/3
 */
public class KthNode {

    // binary search's in-order traversal is sorted,
    // in-order traversal
    int index = 0;
    TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null){
            return null;
        }
        TreeNode l = kthNode(pRoot.left, k);
        if (l != null){
            return l;
        }
        index++;
        if (index == k){
            return pRoot;
        }
        TreeNode r = kthNode(pRoot.right, k);
        if (r != null){
            return r;
        }
        return null;
    }


    TreeNode kthNode2(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0){
            return null;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()){
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            count++;
            if (count == k){
                return pRoot;
            }
            pRoot = pRoot.right;
        }
        return null;
    }
}
