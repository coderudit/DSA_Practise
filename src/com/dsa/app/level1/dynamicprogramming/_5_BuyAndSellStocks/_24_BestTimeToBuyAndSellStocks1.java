package com.dsa.app.level1.dynamicprogramming._5_BuyAndSellStocks;

public class _24_BestTimeToBuyAndSellStocks1 {
    public static void main(String[] args) {

    }

    private int getProfit(int[] dailyPrices) {
        int minimumPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int day = 0; day < dailyPrices.length; day++) {
            if (dailyPrices[day] < minimumPrice) {
                minimumPrice = dailyPrices[day];
            }
            if (dailyPrices[day] - minimumPrice > profit) {
                profit = dailyPrices[day] - minimumPrice;
            }
        }
        return profit;
    }
}
