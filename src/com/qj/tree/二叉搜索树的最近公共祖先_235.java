package com.qj.tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 通过次数188,361提交次数282,058
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 * @author qinjian
 */
public class 二叉搜索树的最近公共祖先_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode ancestor = root;
        while (true) {
            if (p.val > root.val && q.val > root.val) {
                ancestor = ancestor.right;
            } else if (p.val < root.val && q.val < root.val) {
                ancestor = ancestor.left;
            } else {
                break;
            }
        }

        return ancestor;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }

        /**
         * 二叉搜索树
         * 1、如果p、 q 的值都比root 要大， 则在右子树里去找
         * 2、如果p、 q 的值都比root 要小， 则在左子树里去找
         * 3、如果一个比root大、一个比root小， 则root就是最近的祖先
         */
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor2(root.left, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        /**
         * base case
         * 1、如果root为空，肯定得返回null
         * 2、如果root本身就是p或者q，比如说root就是p节点吧，如果q存在于以root为根的树中，显然root就是最近公共祖先
         * 3、即使q不存在于以root为根的树中，也应该返回root节点。
         */
        if (root == null || p == root || q == root) {
            return root;
        }

        // 递归树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /**
         * 情况 1，如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
         *
         * 情况 2，如果p和q都不在以root为根的树中，直接返回null。
         *
         * 情况 3，如果p和q只有一个存在于root为根的树中，函数返回该节点。
         *
         * 1、jvm 对 lamba
         * 2、栈上分配的时机
         */
        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return root;
        }

        return right == null ? left : right;
    }
}