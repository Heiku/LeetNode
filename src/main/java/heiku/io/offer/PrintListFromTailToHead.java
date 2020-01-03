package heiku.io.offer;

import heiku.io.base.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @Author: Heiku
 * @Date: 2020/1/3
 */
public class PrintListFromTailToHead {

    // use recursive to reverse record the listNode
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    // stack
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}
