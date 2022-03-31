package com.dsa.app.final450.Arrays;

public class _10_KadaneAlgo {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        _10_KadaneAlgo obj = new _10_KadaneAlgo();
        System.out.println(obj.maxSubarraySum(nums, nums.length));
    }

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int nums[], int n) {
        int max = nums[0];
        int currentSum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (currentSum >= 0) {
                currentSum = currentSum + nums[index];

            }else{
                currentSum = nums[index];
            }

            if (currentSum > max)
                max = currentSum;
        }
        return max;

    }
}
