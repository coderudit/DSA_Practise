package com.dsa.app.level2.dynamicprogramming;

public class _8_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        _8_LongestIncreasingSubsequence program = new _8_LongestIncreasingSubsequence();
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        program.findLongestIncreasingSubsequence(nums);
    }

    private void findLongestIncreasingSubsequence(int[] nums) {
        //Stores the  longest subsequence till that index with that number as the last.
        int[] dp = new int[nums.length];
        int overallMax = 0;
        for (int index = 0; index < dp.length; index++) {
            int max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (nums[innerIndex] < nums[index] && dp[innerIndex] > max) {
                    max = dp[innerIndex];
                }
            }
            dp[index] = max + 1;
            if (dp[index] > overallMax) {
                overallMax = dp[index];
            }
        }
        System.out.println(overallMax);
    }
}
