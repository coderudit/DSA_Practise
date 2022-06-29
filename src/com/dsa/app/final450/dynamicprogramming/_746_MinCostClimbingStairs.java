package com.dsa.app.final450.dynamicprogramming;

public class _746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 20};
        int[] arr2 = new int[]{1,100,1,1,1,100,1,1,100,1};
        minCostClimbingStairs(arr2);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int m = cost.length;
        int[] dp = new int[m];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < m; i++){
            dp[i] = cost[i] + Math.min(dp[i-2], dp[i-1]);
        }


        return Math.min(dp[m - 1], dp[m - 2]);
    }

    public static int minCostClimbingStairsOptimized(int[] cost) {
        int m = cost.length;

        int prev2 = cost[0];
        int prev1 = cost[1];

        for(int i = 2; i < m; i++){
           int curr = cost[i] + Math.min(prev2, prev1);
           prev2 = prev1;
           prev1 = curr;
        }


        return Math.min(prev2, prev1);
    }
}
