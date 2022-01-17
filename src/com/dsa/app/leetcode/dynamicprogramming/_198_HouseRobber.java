package com.dsa.app.leetcode.dynamicprogramming;

import java.util.HashMap;

public class _198_HouseRobber {
    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private static int[] nums;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        rob(nums);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // Recurrence relation
        }

        return dp[nums.length - 1];
    }


}
