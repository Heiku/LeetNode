package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @Author: Heiku
 * @Date: 2020/2/19
 */
public class TreeDepth {

    // dfs
    public int treeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // bfs
    public int treeDepth2(TreeNode root){
        if (root == null){
            return 0;
        }
        // idx: same floor node index
        // count: the count of the same floor
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0, idx = 0, count = 1;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            idx++;
            if (idx == count){
                depth++;
                idx = 0;
                count = queue.size();
            }
        }
        return depth;
    }
}
