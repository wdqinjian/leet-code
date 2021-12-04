package com.qj.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 *
 * @author qinjian
 */
public class 环形链表II_142 {

    Set<ListNode> visited = null;

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pos = head;
        visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            }
            visited.add(pos);
            pos = pos.next;
        }

        return null;
    }


    public ListNode detectCycle2(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {

            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        // 找到第一次相交的地方
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}