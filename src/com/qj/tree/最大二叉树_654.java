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
public class 最大二叉树_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (maxValue < nums[i]) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }

        // 找到最大的节点作为根节点
        TreeNode root = new TreeNode(maxValue);
        // 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树
        root.left = build(nums, left, maxIndex - 1);
        // 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树
        root.right = build(nums, maxIndex + 1, right);
        return root;
    }
}