package com.qj.tree;

/**
 * @author qinjian
 */
public class 不同的二叉搜索树_96 {

    private int[][] memo;

    public int numTrees(int n) {
        // 备忘录
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int left, int right) {

        // 退出条件
        if (left > right) {
            return 1;
        }

        // 如果已经存在则直接返回
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        // 循环累计基数
        int result = 0;
        for (int i = left; i <= right; i++) {
            int n = count(left, i - 1);
            int m = count(i + 1, right);

            // 左右子树相乘种可能， 左子树都比根节点小，右子树都比根节点大
            result += n * m;
        }
        // 存储当前递归的结果
        memo[left][right] = result;

        return result;
    }
}