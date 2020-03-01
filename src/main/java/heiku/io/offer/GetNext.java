package heiku.io.offer;

import heiku.io.base.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * https://uploadfiles.nowcoder.com/files/20171225/773262_1514198075109_20151104234034251
 *
 * @Author: Heiku
 * @Date: 2020/3/1
 */
public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }

        // if root has right sub tree, find the left node on right sub tree
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        // hasn't right sub tree, left node - > root, find up
        while (pNode.next != null){
            if (pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
