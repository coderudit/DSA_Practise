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
        for (int itemIndex = 1; itemIndex < weights.length; itemIndex++) {
            for (int bgcIndex = 1; bgcIndex <= bagCapacity; bgcIndex++) {
                if (bgcIndex == weights[itemIndex]) {
                    dp[bgcIndex][itemIndex] = Math.max(dp[bgcIndex][itemIndex - 1],
                            values[itemIndex]);
                } else {
                    dp[bgcIndex][itemIndex] = Math.max(dp[bgcIndex - 1][itemIndex],
                            dp[bgcIndex][itemIndex - 1]);
                }
            }
        }
        System.out.println(dp[bagCapacity][weights.length]);
    }
}
