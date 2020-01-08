package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 * @Author: Heiku
 * @Date: 2020/1/8
 */
public class Mirror {

    // use queue, bfs
    public void mirror(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode r = queue.poll();
            if (r.left != null){
                queue.offer(r.left);
            }
            if (r.right != null){
                queue.offer(r.right);
            }
            TreeNode tmp = r.left;
            r.left = r.right;
            r.right = tmp;
        }
    }

    // dfs
    public void mirror2(TreeNode root) {
        if (root == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror2(root.left);
        mirror2(root.right);
    }
}
