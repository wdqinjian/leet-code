package com.qj.tree;

/**
 * @author qinjian
 */
public class 验证二叉搜索树_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

        if (null == root) {
            return true;
        }

        // 整个左子树都要小于 root.val, 整个右子树都要大于 root.val
        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        // 不停的递归去检查左右子树
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}