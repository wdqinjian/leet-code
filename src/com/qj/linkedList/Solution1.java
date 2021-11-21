package com.qj.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {

    }


    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length < 1) {
            return null;
        }

        ListNode dumy = new ListNode(-1);
        Queue<Integer> queue = new PriorityQueue<>(
                Comparator.comparingInt(a -> a)
        );


        return dumy.next;
    }
}