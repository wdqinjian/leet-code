package com.qj.tree;

import java.util.LinkedList;

/**
 * @author qinjian
 */
public class 翻转二叉树_226 {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) return null;

        TreeNode tmep = root.right;
        root.right = root.left;
        root.left = tmep;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (null == root) {
            return null;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {

            // 拿出节点，并交换左右节点
            TreeNode node = list.poll();
            TreeNode tmeps = node.right;
            node.right = node.left;
            node.left = tmeps;

            // 左右节点不为空的话，就加入， 后续处理
            if (node.left != null) {
                list.add(node.left);
            }

            if (node.right != null) {
                list.add(node.right);
            }
        }
        return root;
    }

}