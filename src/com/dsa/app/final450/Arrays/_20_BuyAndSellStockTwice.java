package com.dsa.app.final450.Arrays;

public class _20_BuyAndSellStockTwice {
    public static void main(String[] args) {
        _20_BuyAndSellStockTwice obj = new _20_BuyAndSellStockTwice();
        int[] prices = {10, 22, 5, 75, 65, 80};
        System.out.println(obj.buySellStock(prices));
    }

    private int buySellStock(int[] prices) {
        int max = prices[prices.length - 1];
        int min = prices[prices.length - 1];

        int index = prices.length - 2;

        int profit = 0;
        int profitCount = 0;
        while (index >= 0) {
            if (prices[index] > max) {
                max = prices[index];
            }
            if (prices[index] < min) {
                min = prices[index];
                if ((index - 1 < 0) || (prices[index - 1] > prices[index]) && prices[index] >= min) {
                    profit += (max - min);
                    profitCount++;
                    if (profitCount == 2)
                        break;
                    max = prices[index - 1];
                    min = prices[index - 1];
                    index--;
                }
            }

            index--;
        }

        return profit;
    }
}

