package com.dsa.app.level1.dynamicprogramming;

public class _5_MinCostPath {
    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
    }

    private static int calculateMinCostPath(int[][] cost) {
        int[][] dp = new int[cost.length][cost[0].length];

        for (int rowIndex = dp.length - 1; rowIndex >= 0; rowIndex--) {
            for (int colIndex = dp[0].length - 1; colIndex >= 0; colIndex--) {
                if (rowIndex == dp.length - 1 && colIndex == dp[0].length - 1) {
                    dp[rowIndex][colIndex] = cost[rowIndex][colIndex];
                } else if (rowIndex == dp.length - 1) {
                    dp[rowIndex][colIndex] = cost[rowIndex][colIndex + 1] + cost[rowIndex][colIndex];
                } else if (colIndex == dp[0].length - 1) {
                    dp[rowIndex][colIndex] = cost[rowIndex + 1][colIndex] + cost[rowIndex][colIndex];
                } else {
                    dp[rowIndex][colIndex] = Math.min(cost[rowIndex][colIndex + 1], cost[rowIndex + 1][colIndex])
                            + cost[rowIndex][colIndex];
                }
            }
        }
        return dp[0][0];
    }
}
