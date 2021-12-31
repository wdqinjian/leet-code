package com.qj.tree;

import java.util.List;

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
class BSTIterator {

    private TreeNode root;

    private int index;

    private List<TreeNode> list;

    public BSTIterator(TreeNode root) {
        this.root = root;
        buildList(root);
    }

    public int next() {
        TreeNode node = list.get(index);
        index++;
        return node.val;
    }

    public boolean hasNext() {
        return index != list.size() - 1;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private void buildList(TreeNode root) {

        if (null == root) {
            return;
        }

        buildList(root.left);
        list.add(root);
        buildList(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */