package com.dsa.app.level1.dynamicprogramming;

public class _9_CoinChangePermutation {
    public static void main(String[] args) {
        _9_CoinChangePermutation program = new _9_CoinChangePermutation();
        int[] coins = {2, 3, 5, 6};
        System.out.println(program.coinChangePermutation(coins, 10));
    }

    //Number of ways to pay a target sum using coins.
    private int coinChangePermutation(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //By going to every target with each coins, we check what combinations of coins
        //can pay that amount.
        //If we use that coin for the payment, does previous payment has been done.
        for (int targetIndex = 1; targetIndex <= target; targetIndex++) {
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if (targetIndex - coins[coinIndex] >= 0) {
                    dp[targetIndex] += dp[targetIndex - coins[coinIndex]];
                    System.out.println("Target: " + targetIndex + " Coin: " + coins[coinIndex] +
                            " Coins used: " + dp[targetIndex]);
                }
            }
            System.out.println();
        }
        return dp[target];
    }
}
