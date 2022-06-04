package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

public class _1_MaxSumOfSubarraySizeK {
    public static void main(String[] args) {
        _1_MaxSumOfSubarraySizeK problem = new _1_MaxSumOfSubarraySizeK();
        int[] arr = {2, 5, 1, 8, 2, 1, 1};
        System.out.println(problem.maxSumOfSubarray(3, arr));
    }

    public int maxSumOfSubarray(int k, int[] nums) {
        int overallMax;
        int currentMax = 0;
        for (int index = 0; index < k; index++) {
            currentMax += nums[index];
        }
        overallMax = currentMax;
        for (int index = k; index < nums.length; index++) {
            currentMax -= nums[index - k];
            currentMax += nums[index];
            if (overallMax < currentMax)
                overallMax = currentMax;
        }
        return overallMax;
    }
}
