package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * compare two node
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @Author: Heiku
 * @Date: 2020/3/1
 */
public class IsSymmetrical {

    // dfs
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return false;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        // traversal when arrive end together, success
        if (left == null && right == null){
            return true;
        }
        // if one of them is null, failed
        if (left == null || right == null){
            return false;
        }
        // check the val of do next traversal
        return left.val == right.val
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }



    // bfs
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null){
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            // minor
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
