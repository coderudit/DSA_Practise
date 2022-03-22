package com.dsa.app.leetcode.contest285;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] nums1 = {2, 4, 1, 1, 6, 5};//3
        int[] nums2 = {6, 6, 5, 5, 4, 1};//0
        int[] nums3 = {21, 21, 21, 2, 2, 2, 2, 21, 21, 45};//1
        int[] nums4 = {5, 7, 7, 1, 7};//2
        int[] nums5 = {22, 22, 22, 22, 22, 22, 11, 11, 11, 11, 11, 11, 100, 100, 3};//2
        int[] nums6 = {1, 1, 1, 1, 1, 1, 1, 57, 57, 57, 50, 50, 50, 50, 22, 22, 22, 86};
        int[] nums7 = {57, 57, 57, 57, 57, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 85, 85, 85, 86, 86, 86};
        System.out.println(obj.countHillValley(nums1));
    }

    public int countHillValley(int[] nums) {
        int countHillValley = 0;
        int prev = nums[0];
        for (int index = 1; index < nums.length - 1; index++) {
            if (checkIfCurrentNumberIsLowest(prev, index, nums) || checkIfCurrentNumberIsHighest(prev, index, nums)) {
                countHillValley++;
                prev = nums[index];
            }
        }
        return countHillValley;
    }

    private boolean checkIfCurrentNumberIsLowest(int prev, int index, int[] nums) {
        if (prev > nums[index] && nums[index] < nums[index + 1]) {
            return true;
        }
        return false;
    }

    private boolean checkIfCurrentNumberIsHighest(int prev, int index, int[] nums) {
        if (nums[index] > prev && nums[index] > nums[index + 1]) {
            return true;
        }
        return false;
    }

}
