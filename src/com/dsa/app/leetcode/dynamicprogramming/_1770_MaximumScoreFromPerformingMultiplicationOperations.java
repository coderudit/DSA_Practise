package com.dsa.app.leetcode.dynamicprogramming;

public class _1770_MaximumScoreFromPerformingMultiplicationOperations {
    public static void main(String[] args) {
        var obj = new _1770_MaximumScoreFromPerformingMultiplicationOperations();
        int[] nums = {-5, -3, -3, -2, 7, 1};//{1, 2, 3};
        int[] multipliers = {-10, -5, 3, 4, 6};//{3, 2, 1};
        System.out.println(obj.maximumScore(nums, multipliers));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(mult * nums[left] + dp[i + 1][left + 1],
                        mult * nums[right] + dp[i + 1][left]);
            }
        }

        return dp[0][0];
    }
}
