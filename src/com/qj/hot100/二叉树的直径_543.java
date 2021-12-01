package com.qj.hot100;

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
public class 二叉树的直径_543 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }
        // 左儿子为根的子树的深度
        int L = depth(node.left);
        // 右儿子为根的子树的深度
        int R = depth(node.right);
        // 计算d_node即L+R+1 并更新ans
        ans = Math.max(ans, L + R + 1);
        // 返回该节点为根的子树的深度
        return Math.max(L, R) + 1;
    }
}