package com.dsa.app.level1.dynamicprogramming;

public class _10_01KnapsackProblem {
    public static void main(String[] args) {
        int[] values = {15, 14, 10, 45, 30};
        int[] weights = {2, 5, 1, 3, 4};
        int bagCapacity = 7;
        _10_01KnapsackProblem program = new _10_01KnapsackProblem();
        program.chooseItems(weights, values, bagCapacity);
    }

    private void chooseItems(int[] weights, int[] values, int bagCapacity) {

        int[][] dp = new int[weights.length + 1][bagCapacity + 1];
        for (int itemIndex = 1; itemIndex < dp.length; itemIndex++) {
            for (int bgcIndex = 1; bgcIndex < dp[0].length; bgcIndex++) {
                dp[itemIndex][bgcIndex] = dp[itemIndex - 1][bgcIndex]; //Does not include current weight by default.
                if (bgcIndex >= weights[itemIndex - 1]) {
                    dp[itemIndex][bgcIndex] = Math.max(values[itemIndex - 1] + dp[itemIndex-1][bgcIndex - weights[itemIndex - 1]], dp[itemIndex][bgcIndex]);
                }
            }
        }
        System.out.println(dp[weights.length][bagCapacity]);
        for (int itemIndex = 0; itemIndex < dp.length; itemIndex++) {
            for (int bgcIndex = 0; bgcIndex < dp[0].length; bgcIndex++) {
                System.out.print(dp[itemIndex][bgcIndex] + " ");
            }
            System.out.println();
        }

    }
}
