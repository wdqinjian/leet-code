package com.qj.tree;

import java.util.LinkedList;
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
public class 不同的二叉搜索树II_95 {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int l, int r) {

        List<TreeNode> res = new LinkedList<>();

        if (l > r) {
            res.add(null);
            return res;
        }

        // 1、穷举root 的所有可能性
        for (int i = l; i <= r; i++) {

            // 2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> leftTree = build(l, i - 1);
            List<TreeNode> rightTree = build(i + 1, r);

            // 3、穷举所有左右子树的组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}