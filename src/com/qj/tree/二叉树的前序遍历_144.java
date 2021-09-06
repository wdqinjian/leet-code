package com.qj.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinjian
 */
public class 二叉树的前序遍历_144 {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}