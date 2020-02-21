package heiku.io.offer;

import heiku.io.base.ListNode;

/**
 * （环入口）
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class EntryNodeOfLoop {

    // two pointer (one walks one step, the other wolks two step)
    // if the list has the circle, two pointer will meet on the node of cicle
    // then set the one of pointer to head
    // finally, pointers move on step util they meet
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }

        if (fast == null || fast.next == null){
            return null;
        }
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
