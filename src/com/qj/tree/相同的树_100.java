package com.qj.tree;

import java.util.LinkedList;

/**
 * @author qinjian
 */
public class 相同的树_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<TreeNode> qList = new LinkedList<>();
        pList.offer(p);
        qList.offer(q);

        while (!pList.isEmpty() && !qList.isEmpty()) {
            // 都取出来一个节点
            TreeNode pNode = pList.poll();
            TreeNode qNode = qList.poll();

            if (pNode.val != qNode.val) {
                return false;
            }
            // 取出当前两个节点 各自的左右节点
            TreeNode left1 = pNode.left, right1 = pNode.right, left2 = qNode.left, right2 = qNode.right;

            // 通过异或运算判定
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            // 不为空就加入 list, 进行下一轮的比较， 注意加入的顺序
            if (left1 != null) {
                qList.offer(left1);
            }
            if (right1 != null) {
                qList.offer(right1);
            }
            if (left2 != null) {
                qList.offer(left2);
            }
            if (right2 != null) {
                qList.offer(right2);
            }

        }

        // 两个list 必须同时为空，才是相同的
        return pList.isEmpty() && qList.isEmpty();
    }

}