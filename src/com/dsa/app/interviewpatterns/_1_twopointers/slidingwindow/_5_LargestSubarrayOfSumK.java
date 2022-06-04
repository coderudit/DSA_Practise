package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

public class _5_LargestSubarrayOfSumK {
    public static void main(String[] args) {

    }

    public int largeSubArrayLen(int[] nums, int target) {
        int max = nums[0];
        int maxIndexCount = 1;
        int prevIndex = 0;
        int currIndex = 1;

        while (currIndex < nums.length) {
            if (max + nums[currIndex] >= 0 && max + nums[currIndex] > max) {
                max = max + nums[currIndex];
                if (currIndex - prevIndex > maxIndexCount)
                    maxIndexCount = currIndex - prevIndex;
            }
        }
        return maxIndexCount;
    }
}
