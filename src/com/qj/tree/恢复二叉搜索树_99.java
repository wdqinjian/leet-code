package com.qj.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 * <p>
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 *
 * @author qinjian
 */
public class 恢复二叉搜索树_99 {

    public static void main(String[] args) {

//        TreeNode right3 = new TreeNode(14);
//        TreeNode left3 = new TreeNode(6);
//
//        TreeNode right2 = new TreeNode(13);
        TreeNode left2 = new TreeNode(8);

        TreeNode right1 = new TreeNode(1, null, null);
        TreeNode left1 = new TreeNode(4, left2, null);

        // root = [3,1,4,null,null,2]
        TreeNode root = new TreeNode(3, left1, right1);


        恢复二叉搜索树_99 solution = new 恢复二叉搜索树_99();
        solution.recoverTree(root);

    }

    public void recoverTree(TreeNode root) {

        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;

        //扫面遍历的结果，找出可能存在错误交换的节点x和y 找出了最小的节点和最大的节点
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }

        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    /**
     * 中序遍历二叉树，并将遍历的结果保存到list中
     *
     * @param node
     * @param list
     */
    private void dfs(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

}