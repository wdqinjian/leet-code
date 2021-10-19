package com.qj.tree;

/**
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
public class 二叉树的最近公共祖先_236 {


    // 递归解析：

    // 终止条件：
    //     当越过叶节点，则直接返回 nullnullnull ；
    //     当 rootrootroot 等于 p,qp, qp,q ，则直接返回 rootrootroot ；
    // 递推工作：
    //     开启递归左子节点，返回值记为 leftleftleft ；
    //     开启递归右子节点，返回值记为 rightrightright ；
    // 返回值： 根据 leftleftleft 和 rightrightright ，可展开为四种情况；
    //     当 leftleftleft 和 rightrightright 同时为空 ：说明 rootrootroot 的左 / 右子树中都不包含 p,qp,qp,q ，返回 nullnullnull ；
    //     当 leftleftleft 和 rightrightright 同时不为空 ：说明 p,qp, qp,q 分列在 rootrootroot 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
    //     当 leftleftleft 为空 ，rightrightright 不为空 ：p,qp,qp,q 都不在 rootrootroot 的左子树中，直接返回 rightrightright 。具体可分为两种情况：
    //         p,qp,qp,q 其中一个在 rootrootroot 的 右子树 中，此时 rightrightright 指向 ppp（假设为 ppp ）；
    //         p,qp,qp,q 两节点都在 rootrootroot 的 右子树 中，此时的 rightrightright 指向 最近公共祖先节点 ；
    //     当 leftleftleft 不为空 ， rightrightright 为空 ：与情况 3. 同理；

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        // 利用二叉树的后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}