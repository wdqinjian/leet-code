package com.qj.tree;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针_116 {

    public TreeNode connect(TreeNode root) {
        if (null == root) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int size = queue.size();

            // 循环当前层级的所有元素
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                TreeNode node = queue.poll();

                // 除了当前层的最后一个元素外， 其他元素都是直接指向后面的元素
                if (i != size - 1) {
                    node.next = queue.peek();
                }

                // 左节点不为空，加入队列
                TreeNode node1;
                if ((node1 = node.left) != null) {
                    queue.offer(node1);
                }
                TreeNode node2;
                // 右节点不为空也加入队列，  把下层的元素就依次加入了队列，后续循环处理
                if ((node2 = node.right) != null) {
                    queue.offer(node2);
                }
            }
        }

        return root;
    }


    public TreeNode connect1(TreeNode root) {
        if (null == root) return null;
        connect(root.left, root.right);
        return root;
    }

    private void connect(TreeNode node1, TreeNode node2) {
        // 遇到null 停止
        if (null == node1 || null == node2) {
            return;
        }

        node1.next = node2;

        // 左右连  跨父节点左右链接
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }
}