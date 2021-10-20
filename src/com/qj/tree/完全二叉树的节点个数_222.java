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
 *
 * @author qinjian
 */
public class 完全二叉树的节点个数_222 {

    public static void main(String[] args) {
        
    }

    public int countNodes(TreeNode root) {

        TreeNode left = root, right = root;
        int hl = 0, hr = 0;

        // 算左子树的高度
        while (left != null) {
            left = left.left;
            hl++;
        }

        // 算右子树的高度
        while (right != null) {
            right = right.right;
            hr++;
        }

        // 如果左右子树高度是相同的，则说明当前子树是满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }

        // 普通二叉树的高度 = 1 + 左子树高度 + 右子树高度acc
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}