package com.qj.tree;

public class 二叉搜索树中的插入操作_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val > val) {
            // 比当前值小的往左边放
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            // 比当前值大的往右边放
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}