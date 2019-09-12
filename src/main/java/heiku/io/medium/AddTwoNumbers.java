package heiku.io.medium;

import heiku.io.base.ListNode;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * create a node to record list head (result is a new list)
 * loop l1 l2
 *      get val and carry -> if carry != 0  record it
 *      create node and record the val
 *      change node pointer
 *
 *      note: if two list length is different, set 0 replace it
 *
 * final return res
 *
 *
 * @Author: Heiku
 * @Date: 2019/9/12
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;

        // record carry
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            ListNode cur = new ListNode(0);

            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;

            res.next = cur;
            res = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        return head.next;
    }
}
