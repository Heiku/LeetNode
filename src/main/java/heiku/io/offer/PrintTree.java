package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @Author: Heiku
 * @Date: 2020/3/1
 */
public class PrintTree {

    ArrayList<ArrayList<Integer>> all = new ArrayList<>();
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null){
            return all;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0, count = 1;
        while (!queue.isEmpty()){
            TreeNode root = queue.poll();
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            idx++;
            list.add(root.val);
            if (idx == count){
                idx = 0;
                count = queue.size();
                all.add(list);
                list = new ArrayList<>();
            }
        }
        return all;
    }
}
