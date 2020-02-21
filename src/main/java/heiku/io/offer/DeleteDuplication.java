package heiku.io.offer;

import heiku.io.base.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @Author: Heiku
 * @Date: 2020/2/21
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode root = new ListNode(-1);
        root.next = pHead;

        ListNode p = pHead;
        ListNode last = root;
        while (p != null && p.next != null){
            if (p.val == p.next.val){
                int val = p.val;
                while (p != null && p.val == val){
                    p = p.next;
                }
                // now p is next unique node
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return root.next;
    }
}
