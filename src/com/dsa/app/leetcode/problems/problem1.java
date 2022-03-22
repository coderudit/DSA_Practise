package com.dsa.app.leetcode.problems;

import java.util.Arrays;

public class problem1 {
    public static void main(String[] args) {
        problem1 obj = new problem1();
        int[] nums = {3,3,90,90};
        System.out.println(obj.countElements(nums));
    }

    public int countElements(int[] nums) {
        Arrays.sort(nums);

        int prevStart = 0;
        int start = 1;
        int prevEnd = nums.length - 1;
        int end = nums.length - 2;

        int count = nums.length - 2;
        //if (count < 2)
           // return 0;
        while (start <= end) {


            if (nums[start] == nums[prevStart]) {
                start++;
                prevStart++;
                count--;
            } else if (nums[end] == nums[prevEnd]) {
                end--;
                prevEnd--;
                count--;
            } else {
                return count;
            }
        }
        return 0;
    }
}

