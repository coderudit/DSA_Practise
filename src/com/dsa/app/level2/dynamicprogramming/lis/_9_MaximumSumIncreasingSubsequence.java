package com.dsa.app.level2.dynamicprogramming.lis;

public class _9_MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        _9_MaximumSumIncreasingSubsequence program = new _9_MaximumSumIncreasingSubsequence();
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        program.findLongestIncreasingSubsequence(nums);
    }

    private void findLongestIncreasingSubsequence(int[] nums) {
        int overallSum = 0;
        int[] dp = new int[nums.length];
        for (int index = 0; index < dp.length; index++) {
            int sum = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (nums[innerIndex] < nums[index] && dp[innerIndex] > sum) {
                    sum = dp[innerIndex];
                }
            }
            dp[index] = sum + nums[index];
            if (dp[index] > overallSum) {
                overallSum = dp[index];
            }
        }
        System.out.println(overallSum);
    }
}
