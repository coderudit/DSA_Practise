package com.dsa.app.leetcode.monthlychallenge.may;

public class _2_905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {
            if (nums[startIndex] % 2 == 0 && nums[endIndex] % 2 == 1) {
                startIndex++;
                endIndex--;
            }

            else if (nums[startIndex] % 2 == 1) {
                int temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;
                endIndex--;
            }

            else if (nums[endIndex] % 2 == 0){
                int temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;
                startIndex++;
            }

        }

        return nums;
    }
}
