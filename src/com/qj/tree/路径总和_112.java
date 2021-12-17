package com.qj.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
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
public class 路径总和_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // 存放二叉树的节点
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        // 存放 和
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode current = queNode.poll();
            Integer val = queVal.poll();
            if (current.left == null && current.right == null) {
                if (val == targetSum) {
                    return true;
                }
                // 跳出当次循环
                continue;
            }
            // 左子树不为空，继续处理左子树
            if (current.right != null) {
                queNode.offer(current.right);
                queVal.offer(val + current.right.val);
            }
            // 右子树不为空， 继续处理右子树
            if (current.left != null) {
                queNode.offer(current.left);
                queVal.offer(val + current.left.val);
            }

        }

        return false;
    }


    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // 简化，  每一层满足就是等于 总值减去上一层的值
        return hasPathSum1(root.left, targetSum - root.val)
                || hasPathSum1(root.right, targetSum - root.val);
    }

}