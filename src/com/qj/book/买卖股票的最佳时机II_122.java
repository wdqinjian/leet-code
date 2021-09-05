package com.qj.book;

/**
 * @author qinjian
 */
public class 买卖股票的最佳时机II_122 {

    public static void main(String[] args) {
        买卖股票的最佳时机II_122 a = new 买卖股票的最佳时机II_122();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int max = a.maxProfit(prices);

        System.out.println(max);
    }

    public int maxProfit(int[] prices) {

        // 定义最大值
        int max = 0;
        int length = prices.length;

        // 如果数据长度为 0、1，则无收益
        if (length < 2) {
            return max;
        }

        for (int i = 0; i < length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max = max + prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}