package com.qj.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinjian
 */
public class 二叉树的后序遍历_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}