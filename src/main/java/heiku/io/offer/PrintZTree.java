package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @Author: Heiku
 * @Date: 2020/3/1
 */
public class PrintZTree {
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null){
            return listAll;
        }
        int layer = 1;

        Stack<TreeNode> odd = new Stack<>();
        odd.push(pRoot);
        Stack<TreeNode> even = new Stack<>();

        while (!odd.empty() || !even.empty()){
            if (layer % 2 != 0){
                ArrayList<Integer> tmpList = new ArrayList<>();
                while (!odd.empty()){
                    TreeNode root= odd.pop();

                    if (root != null){
                        tmpList.add(root.val);
                        even.push(root.left);
                        even.push(root.right);
                    }
                }
                if (!tmpList.isEmpty()){
                    listAll.add(tmpList);
                    layer++;
                }
            }else {
                ArrayList<Integer> tmpList = new ArrayList<>();
                while (!even.empty()){
                    TreeNode root = even.pop();

                    if (root != null) {
                        tmpList.add(root.val);
                        odd.push(root.right);
                        odd.push(root.left);
                    }
                }
                if (!tmpList.isEmpty()){
                    listAll.add(tmpList);
                    layer++;
                }
            }
        }
        return listAll;
    }
}
