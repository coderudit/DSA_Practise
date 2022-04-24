package com.dsa.app.level1.dynamicprogramming._5_BuyAndSellStocks;

public class _26_BestTimeToBuyAndSellStocks3 {
    public static void main(String[] args) {
        _26_BestTimeToBuyAndSellStocks3 program = new _26_BestTimeToBuyAndSellStocks3();
        int[] prices = {5, 2, 7, 3, 6, 1, 2, 4};
        int[] prices2 = {1, 2, 3};
        int[] prices3 = {10,20,30};
        int fee = 2;
        System.out.println(program.getProfit(prices3, fee));
        //System.out.println(program.getProfit2(prices));
    }

    private int getProfit(int[] prices, int fee) {
        int oldBuy = -prices[0];
        int oldSell = 0;

        for (int day = 1; day < prices.length; day++) {
            int newBuy = oldBuy;
            int newSell = oldSell;

            if (oldSell - prices[day] > oldBuy) {
                newBuy = oldSell - prices[day];
            }
            if (prices[day] + oldBuy - fee > oldSell) {
                newSell = prices[day] + oldBuy - fee;
            }
            oldBuy = newBuy;
            oldSell = newSell;
        }
        return oldSell;
    }
}
