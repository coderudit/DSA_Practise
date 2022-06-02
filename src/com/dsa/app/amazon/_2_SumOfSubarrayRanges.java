package com.dsa.app.amazon;

public class _2_SumOfSubarrayRanges {
    public static void main(String[] args) {

    }

    //Brute-force
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int index = 0; index < nums.length; index++) {
            int min = nums[index];
            int max = nums[index];
            for (int innerIndex = index; innerIndex < nums.length; innerIndex++) {
                min = Math.min(min, nums[innerIndex]);
                max = Math.max(max, nums[innerIndex]);
                sum += Math.abs(max - min);
            }
        }
        return sum;
    }
}
