package com.dsa.app.level1.dynamicprogramming;

public class _8_CoinChangeCombination {
    public static void main(String[] args) {
        _8_CoinChangeCombination program = new _8_CoinChangeCombination();
        int[] coins = {2, 3, 5, 6};
        System.out.println(program.coinChangeCombination(coins, 10));
    }

    private int coinChangeCombination(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
            for (int targetIndex = coins[coinIndex]; targetIndex <= target; targetIndex++) {
                dp[targetIndex] += dp[targetIndex - coins[coinIndex]];
                System.out.println("Target: " + targetIndex + " Coin: " + coins[coinIndex] +
                        " Coins used: " + dp[targetIndex]);
            }
            System.out.println();
        }

        return dp[target];
    }
}
