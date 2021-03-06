package com.dsa.app.final450.Arrays;

public class _11_A_BestTimeToBuyAndSellStock1 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        _11_A_BestTimeToBuyAndSellStock1 obj = new _11_A_BestTimeToBuyAndSellStock1();
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int index = 0; index < prices.length; index++) {
            if (prices[index] < min) {
                min = prices[index];
            }

            if (prices[index] - min > profit) {
                profit = prices[index] - min;
            }
        }

        return profit;
    }
}
