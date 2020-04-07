package heiku.io.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 *
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example, given a 3-ary tree:
 *
 *
 * https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png
 *
 * We should return its max depth, which is 3.
 *
 *
 * @Author: Heiku
 * @Date: 2019/9/10
 */
public class MaxDepth {


    public int maxDepth(Node root) {
        if(root == null) return 0;

        int maxDepth = 0;

        for(Node child : root.children)
            maxDepth = Math.max(maxDepth, maxDepth(child));

        return maxDepth + 1;
    }

    // queue store node
    // poll each floor and plus depth
    public int maxDepth2(Node root) {

        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                for(Node child: current.children) queue.offer(child);
            }

            depth++;
        }

        return depth;
    }
}
