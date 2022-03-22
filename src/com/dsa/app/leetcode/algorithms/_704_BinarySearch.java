package com.dsa.app.leetcode.algorithms;

import java.util.Arrays;

public class _704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int searchindex = search(nums, target);
        System.out.println(searchindex);
    }

    private static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid])
                max = mid;
            else
                min = mid+1;
        }
        return -1;
    }
}
