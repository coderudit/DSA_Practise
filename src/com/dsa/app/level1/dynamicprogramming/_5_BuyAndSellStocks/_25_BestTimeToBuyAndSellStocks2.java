package com.dsa.app.level1.dynamicprogramming._5_BuyAndSellStocks;

public class _25_BestTimeToBuyAndSellStocks2 {
    public static void main(String[] args) {
        _25_BestTimeToBuyAndSellStocks2 program = new _25_BestTimeToBuyAndSellStocks2();
        int[] prices = {5, 2, 7, 3, 6, 1, 2, 4};
        int[] prices2 = {1,2,3};
        System.out.println(program.getProfit(prices));
        System.out.println(program.getProfit2(prices));
    }

    private int getProfit(int[] prices) {
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index - 1]) {
                profit += (prices[index] - prices[index - 1]);
            }
        }
        return profit;
    }

    private int getProfit2(int[] arr){

        int bon = 0;
        int son = 0;
        int op = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                op += arr[son] - arr[bon];
                bon = son = i;
            } else {
                son++;
            }
        }

        op += arr[son] - arr[bon];
        //System.out.println(op);
        return op;
    }
}
