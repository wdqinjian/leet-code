package com.qj.book;

/**
 * @author qinjian
 */
public class 买卖股票的最佳时机_121 {

    public static void main(String[] args) {
        买卖股票的最佳时机_121 a = new 买卖股票的最佳时机_121();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int max = a.maxProfit(prices);

        System.out.println(max);
    }


    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}