package com.dsa.app.leetcode.problems;

public class problem2 {
    public static void main(String[] args) {
        problem2 obj = new problem2();
        int[] nums = {-1,1};
        int[] newNums = obj.rearrangeArray(nums);
        System.out.println();
    }

    public int[] rearrangeArray(int[] nums) {

        int positiveIndex = 0;
        int negativeIndex = 1;
        int[] newArr = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] >= 0) {
                newArr[positiveIndex] = nums[index];
                positiveIndex += 2;
            } else {
                newArr[negativeIndex] = nums[index];
                negativeIndex += 2;
            }
        }
        return newArr;
    }
}
