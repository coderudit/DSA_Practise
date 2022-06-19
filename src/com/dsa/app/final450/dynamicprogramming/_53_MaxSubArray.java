package com.dsa.app.final450.dynamicprogramming;

public class _53_MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        _53_MaxSubArray obj = new _53_MaxSubArray();
        obj.maxSubArray(nums);
    }

    public int maxSubArray(int[] nums) {
        int max = 0;
        int currentSum = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > currentSum) {
                currentSum = nums[index];
            }else{
                currentSum = currentSum + nums[index];
            }

            if (currentSum > max)
                max = currentSum;
        }
        return max;
    }
}
