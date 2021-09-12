package com.qj.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qinjian
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;


    public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildNode() {

        TreeNode right3 = new TreeNode(14);
        TreeNode left3 = new TreeNode(6);

        TreeNode right2 = new TreeNode(13);
        TreeNode left2 = new TreeNode(7);

        TreeNode right1 = new TreeNode(11, left3, right3);
        TreeNode left1 = new TreeNode(8, left2, right2);

        TreeNode root = new TreeNode(10, left1, right1);

        return root;
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

}