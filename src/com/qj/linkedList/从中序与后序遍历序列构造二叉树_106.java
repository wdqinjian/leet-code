package com.qj.linkedList;

import com.qj.tree.TreeNode;

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
public class 从中序与后序遍历序列构造二叉树_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inBegin, int inEnd,
                           int[] postorder, int postBegin, int postEnd) {

        if (inBegin > inBegin || postBegin > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length - 1; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inBegin;
        root.left = build(inorder, 0, rootIndex - 1,
                postorder, 0, leftSize);
        root.right = build(inorder, rootIndex + 1, inEnd,
                postorder, leftSize + 1, postEnd);

        return root;
    }
}