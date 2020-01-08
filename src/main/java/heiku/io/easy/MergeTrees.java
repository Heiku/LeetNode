package heiku.io.easy;

import heiku.io.base.TreeNode;

/**
 * @Author: Heiku
 * @Date: 2019/8/8
 *
 * 617. Merge Two Binary Trees
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTrees {

    // add tree node into t1
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;

        mergeTrees2(t1.left, t2.left);
        mergeTrees2(t1.right, t2.right);

        return t1;
    }



    // build a new tree
    // tree traversal
    // Runtime: 1 ms, faster than 56.02% of Java online
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }

        TreeNode tn;
        if (t1 == null) {
            tn = new TreeNode(t2.val);
        }else if (t2 == null){
            tn = new TreeNode(t1.val);
        }else {
            tn = new TreeNode(t1.val + t2.val);
        }

        tn.left = mergeTrees(t1 == null? null : t1.left, t2 == null ? null : t2.left);
        tn.right = mergeTrees(t1 == null ? null : t1.right, t2 == null? null : t2.right);

        return tn;
    }
}
