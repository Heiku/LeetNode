package heiku.io.offer;

import heiku.io.base.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树（Balanced Binary Tree）具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 *
 * @Author: Heiku
 * @Date: 2020/2/19
 */
public class IsBalancedTree {

    boolean isBalanced = true;
    public boolean isBalancedTree(TreeNode root) {
        if (root == null){
            return true;
        }
        depthTree(root);
        return isBalanced;
    }

    public int depthTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depthTree(root.left);
        int right = depthTree(root.right);
        if (Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
