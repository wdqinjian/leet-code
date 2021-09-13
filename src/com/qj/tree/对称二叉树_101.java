package com.qj.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qinjian
 */
public class 对称二叉树_101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        // 同时空则对称
        if (node1 == null && node2 == null) {
            return true;
        }
        // 不同时为空则不对称
        if (node1 == null || node2 == null) {
            return false;
        }
        // 值相同， 且所有节点均对称，
        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
    }

    private boolean check1(TreeNode node1, TreeNode node2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node1);
        queue.offer(node2);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            // 此处不能return 还得接着继续检查
            if (p == null && q == null) {
                continue;
            }

            if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

}