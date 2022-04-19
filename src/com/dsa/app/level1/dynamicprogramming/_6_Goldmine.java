package com.dsa.app.level1.dynamicprogramming;

public class _6_Goldmine {
    public static void main(String[] args) {

    }

    public int getMaximumGold(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int colIndex = grid[0].length - 1; colIndex >= 0; colIndex--) {
            for (int rowIndex = grid.length - 1; rowIndex >= 0; rowIndex--) {
                if (colIndex == grid[0].length - 1) {
                    dp[rowIndex][colIndex] = grid[rowIndex][colIndex];
                } else if (rowIndex == 0) {
                    dp[rowIndex][colIndex] = grid[rowIndex][colIndex] +
                            Math.max(dp[rowIndex][colIndex + 1],
                                    dp[rowIndex + 1][colIndex + 1]);
                } else if (rowIndex == grid.length - 1) {
                    dp[rowIndex][colIndex] = grid[rowIndex][colIndex] +
                            Math.max(dp[rowIndex - 1][colIndex + 1],
                                    dp[rowIndex][colIndex + 1]);
                } else {
                    dp[rowIndex][colIndex] = grid[rowIndex][colIndex] +
                            Math.max(Math.max(dp[rowIndex - 1][colIndex + 1],
                                            dp[rowIndex][colIndex + 1]),
                                    dp[rowIndex + 1][colIndex + 1]);
                }

            }
        }

        int max = dp[0][0];
        for (int rowIndex = 1; rowIndex < dp.length; rowIndex++) {
            if (dp[rowIndex][0] > max) {
                max = dp[rowIndex][0];
            }
        }
        return max;
    }
}
