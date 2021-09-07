package com.qj.tree;

/**
 * @author qinjian
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

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
}