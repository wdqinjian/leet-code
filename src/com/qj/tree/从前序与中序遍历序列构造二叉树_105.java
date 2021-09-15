package com.qj.tree;

/**
 * @author qinjian
 */
public class 从前序与中序遍历序列构造二叉树_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        // 退出条件
        if (preStart > preEnd) return null;

        // root节点的值， 前序遍历的第一个值永远是 根节点
        int rootVal = preorder[preStart];
        int index = -1;
        // 找到中序遍历中， 根节点所在的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                // 不能漏，找到跳出
                break;
            }
        }

        // 借助于 中序遍历的root  index, 算出来左子树的 size.  中序遍历的特点是  root 左边是左子树， 右边是右子树
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}