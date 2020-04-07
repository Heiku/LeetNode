package heiku.io.leetcode.easy;

import heiku.io.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 965. Univalued Binary Tree
 *
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 * Example 1:
 *
 * https://assets.leetcode.com/uploads/2018/12/28/unival_bst_1.png
 *
 *      Input: [1,1,1,1,1,null,1]
 *      Output: true
 *
 * Example 2:
 *
 * https://assets.leetcode.com/uploads/2018/12/28/unival_bst_2.png
 *
 *      Input: [2,2,2,5,2]
 *      Output: false
 *
 * @Author: Heiku
 * @Date: 2019/8/21
 */
public class IsUnivalTree {

    // Runtime: 0 ms, faster than 100%
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int v){
        if (root == null){
            return true;
        }
        if (root.val != v){
            return false;
        }

        return dfs(root.left, v) && dfs(root.right, v);
    }


    // Runtime: 1 ms, faster than 14.36%
    Set<Integer> set = new HashSet<>();
    public boolean isUnivalTree2(TreeNode root) {
        travse(root);

        return set.size() == 1;
    }

    private void travse(TreeNode root){
        if (root == null){
            return;
        }

        set.add(root.val);

        travse(root.left);
        travse(root.right);
    }
}
