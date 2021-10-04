package com.qj.tree;

/**
 * @author qinjian
 */
public class 二叉搜索树中的搜索_700 {
    
    public TreeNode searchBST(TreeNode root, int val) {

        // 需要判空
        if (null == root) return null;

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }

        return null;
    }
}