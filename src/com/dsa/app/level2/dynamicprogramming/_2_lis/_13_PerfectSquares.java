package com.dsa.app.level2.dynamicprogramming._2_lis;

public class _13_PerfectSquares {
    public static void main(String[] args) {
        _13_PerfectSquares program = new _13_PerfectSquares();
        program.findMinSquares(5);
    }

    private int findMinSquares(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index < dp.length; index++) {
            int min = Integer.MAX_VALUE;
            for (int innerIndex = 1; innerIndex * innerIndex <= index; innerIndex++) {
                int currentValue = index - (innerIndex * innerIndex);
                if (dp[currentValue] < min) {
                    min = dp[currentValue];
                }
            }
            dp[index] = min + 1;
        }
        return dp[num];
    }
}
