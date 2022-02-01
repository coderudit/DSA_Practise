package com.dsa.app.leetcode.dynamicprogramming;

public class _121_BestTimeToSellStock {
    public static void main(String[] args) {
        _121_BestTimeToSellStock obj = new _121_BestTimeToSellStock();
        int[] arr = {7, 1, 5, 3, 6, 4};
        obj.maxProfit(arr);

    }

    public int maxProfit(int[] prices) {
        int minBuyValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int index = 0; index < prices.length; index++) {
            if (prices[index] < minBuyValue) minBuyValue = prices[index];

            int todayProfit = prices[index] - minBuyValue;

            if (todayProfit > maxProfit)
                maxProfit = todayProfit;

        }
        return maxProfit;
    }
}
