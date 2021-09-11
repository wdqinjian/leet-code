package com.qj;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 零钱兑换_322 {

    public static void main(String[] args) {
        零钱兑换_322 demo = new 零钱兑换_322();
        int[] coins = {1, 2, 5};
        int fib = demo.coinChange(coins, 10);
        System.out.println(" result : " + fib);
    }

    public int coinChange(int[] coins, int amount) {
        int[] coinsTmep = new int[amount + 1];
        // 填充上一个约定的 特殊值
        Arrays.fill(coinsTmep, amount + 1);

        coinsTmep[0] = 0;
        for (int i = 1; i < coinsTmep.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                coinsTmep[i] = Math.min(coinsTmep[i], 1 + coinsTmep[i - coin]);
            }
        }

        return coinsTmep[amount] == amount + 1 ? -1 : coinsTmep[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int[] coinsTmep = new int[amount + 1];
        // 填充上一个约定的 特殊值
        Arrays.fill(coinsTmep, -666);
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount, coinsTmep);
    }

    private int dp(int[] coins, int amount, int[] coinsTmep) {

        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // 如果已经缓存了，则直接返回
        if (-666 != coinsTmep[amount]) {
            return coinsTmep[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin, coinsTmep);
            // 子问题无解则跳过
            if (subProblem == -1) {
                continue;
            }
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        coinsTmep[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return coinsTmep[amount];
    }
}