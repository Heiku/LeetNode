package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @Author: Heiku
 * @Date: 2020/1/20
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            root = queue.poll();

            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            list.add(root.val);
        }
        return list;
    }
}
