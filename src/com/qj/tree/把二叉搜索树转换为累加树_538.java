package com.qj.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class 把二叉搜索树转换为累加树_538 {

    int num = 0;

    public TreeNode convertBST(TreeNode root) {

        if (root != null) {
            // 利用中序遍历a
            convertBST(root.right);

            // 不停的累加
            num += root.val;
            root.val = num;
            convertBST(root.left);
        }

        return root;
    }

}