package com.qj.linkedList;


import java.util.PriorityQueue;

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
public class 合并K个升序链表_23 {

    public static void main(String[] args) {
        合并K个升序链表_23 demo = new 合并K个升序链表_23();
        ListNode n3 = new ListNode(5);
        ListNode n2 = new ListNode(4, n3);
        ListNode head = new ListNode(1, n2);

        ListNode m3 = new ListNode(4);
        ListNode m2 = new ListNode(3, m3);
        ListNode head2 = new ListNode(1, m2);

        // ListNode f3 = new ListNode(9);
        ListNode f2 = new ListNode(6);
        ListNode head3 = new ListNode(2, f2);

        // ListNode[] lists = [[1, 4, 5],[1, 3, 4],[2, 6]]
        ListNode[] lists = {head, head2, head3};
        ListNode root = demo.mergeKLists(lists);
        System.out.println(root);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 判空
        if (null == lists || lists.length == 0) {
            return null;
        }

        // 优先级队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (ListNode head : lists) {
            if (null != head) {
                queue.add(head);
            }
        }

        while (!queue.isEmpty()) {

            ListNode node = queue.poll();

            // 每次只会移除一个节点，并且会立马加入他的下一个节点
            if (node.next != null) {
                queue.add(node.next);
            }
            p.next = node;

            p = p.next;
        }

        return dummy.next;
    }
}