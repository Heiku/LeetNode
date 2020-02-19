package heiku.io.offer;

import heiku.io.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * hash / 交换头节点遍历
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * @Author: Heiku
 * @Date: 2020/2/19
 */
public class FindFirstCommonNode {

    // if the same len, p1 p2 will get the common node in same time
    // if not, the short listNode will get the end firstly, then walk the long listNode
    //          the long listNode will get the end secondly, the walk the short listNode
    //          they will get the same node in final
    //          (if get the final, change the walk path)
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2){
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

    // map
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (pHead1 != null){
            map.put(pHead1, 1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            if (map.containsKey(pHead2)){
                return pHead2;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
