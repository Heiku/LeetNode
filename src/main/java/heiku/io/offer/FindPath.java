package heiku.io.offer;

import heiku.io.base.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @Author: Heiku
 * @Date: 2020/2/17
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null){
            return listAll;
        }
        target -= root.val;
        list.add(root.val);

        if (target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);

        // find failed, back to root and remove the last record
        list.remove(list.size() - 1);
        return listAll;
    }
}
