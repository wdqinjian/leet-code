package com.qj.tree;

public class  填充每个节点的下一个右侧节点指针_116 {

    public TreeNode connect(TreeNode root) {
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