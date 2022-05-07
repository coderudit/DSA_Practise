package com.dsa.app.leetcode.monthlychallenge.may;

import java.util.Arrays;

public class _3_581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        _3_581_ShortestUnsortedContinuousSubarray program = new _3_581_ShortestUnsortedContinuousSubarray();
    }

    public int findUnsortedSubarrayOptimized(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != newNums[index]) {
                min = Math.min(min, index);
                max = Math.max(max, index);
            }
        }

        if(max == Integer.MIN_VALUE && min == Integer.MAX_VALUE)
            return 0;
        return max - min + 1;
    }
}
