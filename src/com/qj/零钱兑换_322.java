package com.qj;

public class 零钱兑换_322 {

    public static void main(String[] args) {
        零钱兑换_322 demo = new 零钱兑换_322();
        int[] coins = {1, 2, 5};
        int fib = demo.coinChange(coins, 11);
        System.out.println(" result : " + fib);
    }

    public int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {

        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == -5 ? -1 : res;
    }

}