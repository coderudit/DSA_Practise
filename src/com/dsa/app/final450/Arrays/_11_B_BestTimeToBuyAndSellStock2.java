package com.dsa.app.final450.Arrays;

public class _11_B_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        _11_B_BestTimeToBuyAndSellStock2 obj = new _11_B_BestTimeToBuyAndSellStock2();
        int[] prices = {5, 2, 7, 3, 6, 1, 2, 4};
        System.out.println(obj.maxProfit(prices));
    }

    private int maxProfit(int[] prices) {
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index - 1]) {
                profit += (prices[index] - prices[index - 1]);
            }
        }
        return profit;
    }
}
