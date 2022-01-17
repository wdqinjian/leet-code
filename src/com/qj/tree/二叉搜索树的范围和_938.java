package com.qj.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * @author qinjian
 */
public class 二叉搜索树的范围和_938 {

    /**
     * 按深度优先搜索的顺序计算范围和。记当前子树根节点为 root，分以下四种情况讨论：
     * <p>
     * 1、root 节点为空
     * <p>
     * 返回 0。
     * <p>
     * 2、root 节点的值大于 high
     * <p>
     * 由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于 high，故无需考虑右子树，返回左子树的范围和。
     * <p>
     * 3、root 节点的值小于 low
     * <p>
     * 由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于 low，故无需考虑左子树，返回右子树的范围和。
     * <p>
     * 4、root 节点的值在[low,high] 范围内
     * <p>
     * 此时应返回 root 节点的值、左子树的范围和、右子树的范围和这三者之和。
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        // 深度优先搜索
        if (root == null) {
            return 0;
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


    public int rangeSumBST2(TreeNode root, int low, int high) {

        // 广度优先搜索
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            // 如果为空，跳过
            if (poll == null) {
                continue;
            }

            if (poll.val > high) {
                q.offer(poll.left);
            } else if (poll.val < low) {
                q.offer(poll.right);
            } else {
                sum += poll.val;
                q.offer(poll.left);
                q.offer(poll.right);
            }
        }
        return sum;
    }

}