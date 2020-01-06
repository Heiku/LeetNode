package heiku.io.offer;

import heiku.io.base.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @Author: Heiku
 * @Date: 2020/1/6
 */
public class MergeSortList {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode root = head;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                head.next = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        // deal with left list
        head.next = list1 == null ? list2 : list1;
        return root.next;
    }
}
