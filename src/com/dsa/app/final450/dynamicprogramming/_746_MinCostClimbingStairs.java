package com.dsa.app.final450.dynamicprogramming;

public class _746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 20};
        int[] arr2 = new int[]{1,100,1,1,1,100,1,1,100,1};
        minCostClimbingStairs(arr2);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int index = 2; index <= cost.length; index++){
            dp[index] =  Math.min(cost[index-1] + dp[index-1], cost[index-2] + dp[index-2]);
        }
        return dp[cost.length];
    }
}
