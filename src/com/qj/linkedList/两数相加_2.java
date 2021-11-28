package com.qj.linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author qinjian
 */
public class 两数相加_2 {

    public static void main(String[] args) {
        两数相加_2 demo = new 两数相加_2();

//        ListNode n3 = new ListNode(5);
//        ListNode n2 = new ListNode(4, n3);
//        ListNode head = new ListNode(1, n2);
//
//        ListNode m3 = new ListNode(4);
//        ListNode m2 = new ListNode(3, m3);
//        ListNode head2 = new ListNode(1, m2);

        // [0]
        // [0]
//        ListNode head = new ListNode(0);
//        ListNode head2 = new ListNode(0);

        // [9]
        // [1,9,9,9,9,9,9,9,9,9]
        ListNode head = new ListNode(9);

        ListNode m10 = new ListNode(9);
        ListNode m9 = new ListNode(9, m10);
        ListNode m8 = new ListNode(9, m9);
        ListNode m7 = new ListNode(9, m8);
        ListNode m6 = new ListNode(9, m7);
        ListNode m5 = new ListNode(9, m6);
        ListNode m4 = new ListNode(9, m5);
        ListNode m3 = new ListNode(9, m4);
        ListNode m2 = new ListNode(9, m3);
        ListNode head2 = new ListNode(1, m2);

        ListNode listNode = demo.addTwoNumbers(head, head2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long result = add(l1) + add(l2);

        ListNode pre = new ListNode(0);
        if (result == 0) {
            return pre;
        }

        ListNode cur = pre;
        while (result > 0) {
            cur.next = new ListNode((int) (result % 10));
            result = result / 10;
            cur = cur.next;
        }

        return pre.next;
    }

    private long add(ListNode listNode) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (listNode != null) {
            stack.addFirst(listNode.val);
            listNode = listNode == null ? null : listNode.next;
        }
        long num = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            int var = stack.removeFirst();
            num = (long) (num + var * Math.pow(10, size - 1));
        }
        return num;
    }
}