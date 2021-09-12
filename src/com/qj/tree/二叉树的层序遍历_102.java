package com.qj.tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qinjian
 */
public class 二叉树的层序遍历_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 构造一个 list 容器
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        // 如果根节点为空，则直接返回
        if (root == null) {
            return ret;
        }

        // 把待处理的 node 加入进去
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            // 当前层级的容器
            List<Integer> level = new LinkedList<Integer>();
            // 当前层级待处理元素的个数
            int currentLevelSize = queue.size();
            // 循环处理所有的元素
            for (int i = 1; i <= currentLevelSize; ++i) {
                // 依次把当前层级的元素加入
                TreeNode node = queue.poll();
                level.add(node.val);

                // 把当前层级的所有元素都加入进去
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

}