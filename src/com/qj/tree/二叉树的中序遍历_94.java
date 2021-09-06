package com.qj.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinjian
 */
public class 二叉树的中序遍历_94 {

    public static void main(String[] args) {
        二叉树的中序遍历_94 demo = new 二叉树的中序遍历_94();
        List<Integer> list = demo.inorderTraversal(null);
        list.forEach(System.out::println);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}