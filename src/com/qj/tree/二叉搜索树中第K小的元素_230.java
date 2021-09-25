package com.qj.tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树中第K小的元素_230 {


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list.get(k - 1);
    }

    private List<Integer> helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return list;
        }
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
        return list;
    }
}