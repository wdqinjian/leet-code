package com.qj.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class 回文链表_234 {

    // 记录最左侧的节点
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode head) {
        if (head == null) return true;

        // 不断的递归调用
        boolean res = traverse(head.next);

        // 第一次进行比较的时候是递归到了链表的最后一个节点，
        res = res && (left.val == head.val);
        // 记录的左节点往前移动
        left = left.next;
        return res;

    }

    public boolean isPalindrome1(ListNode head) {

        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // if(vals.get(front) != vals.get(back)){
            //     return false;
            // }
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}