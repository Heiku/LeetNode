package heiku.io.offer;

import heiku.io.base.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @Author: Heiku
 * @Date: 2020/1/6
 */
public class ReverseList {

    // two pointer record status
    public ListNode reverseList2(ListNode head) {
        // pointer p, q
        ListNode p = null;
        while (head != null){
            ListNode q = head.next;
            head.next = p;
            p = head;
            head = q;
        }
        return p;
    }
}