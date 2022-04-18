package com.dsa.app.level1.dynamicprogramming;

public class _4_ClimbingStairsWithMinMoves {
    public static void main(String[] args) {
        _4_ClimbingStairsWithMinMoves program = new _4_ClimbingStairsWithMinMoves();
        int[] varPathsArr = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        System.out.println(program.minNumberOfPathsTabulation(varPathsArr));
    }

    private int minNumberOfPathsTabulation(int[] varPathsArr) {
        int[] dp = new int[varPathsArr.length + 1];
        dp[varPathsArr.length] = 0;

        for (int pathIndex = varPathsArr.length - 1; pathIndex >= 0; pathIndex--) {
            int min = Integer.MAX_VALUE;
            for (int dpIndex = 1;
                 dpIndex <= varPathsArr[pathIndex] && pathIndex + dpIndex < dp.length;
                 dpIndex++) {
                min = Math.min(min, dp[pathIndex + dpIndex]);
            }
            if (min != Integer.MAX_VALUE)
                dp[pathIndex] = min + 1;
            else
                dp[pathIndex] = min;
        }
        return dp[0];
    }
}
