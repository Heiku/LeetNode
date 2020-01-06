package heiku.io.offer;

import heiku.io.base.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @Author: Heiku
 * @Date: 2020/1/6
 */
public class FindKthToTail {

    // two pointer, first move the fast pointer to the front k in the list,
    // then move the slow and fast pointer to next, while fast == null
    // at this time, the slow pointer is the kth to tail of list
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0){
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
