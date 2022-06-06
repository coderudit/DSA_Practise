package com.dsa.app.leetcode.contest296;

import java.util.Arrays;

public class Program2 {
    public static void main(String[] args) {
        Program2 problem = new Program2();
        int[] nums = {2};//{2,2,4,5}; //{3, 6, 1, 2, 5};
        int k = 0;
        System.out.println(problem.partitionArray(nums, k));
    }

    public int partitionArray(int[] nums, int k) {
        if(nums.length == 1){
            return 1;
        }
        int partitionCount = 1;
        int prevIndex = 0;
        Arrays.sort(nums);
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] - nums[prevIndex] > k) {
                partitionCount++;
                prevIndex = index;
            }
        }
        return partitionCount;
    }


}
