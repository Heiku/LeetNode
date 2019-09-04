package heiku.io.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 933. Number of Recent Calls
 *
 *
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 *
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 *
 *
 * Example 1:
 *
 *      Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 *      Output: [null,1,2,3,3]
 *
 * @Author: Heiku
 * @Date: 2019/8/14
 */
public class RecentCounter {
    Deque<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peekFirst() < t - 3000)
        {
            queue.pollFirst();
        }

        queue.addLast(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */