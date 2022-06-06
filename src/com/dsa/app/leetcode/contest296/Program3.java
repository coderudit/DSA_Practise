package com.dsa.app.leetcode.contest296;

import java.util.HashMap;

public class Program3 {
    public static void main(String[] args) {
        Program3 problem = new Program3();
        int[] nums = {1,2};
        int[][] operations= {{1,3},{2,1},{3,2}};
        problem.arrayChange(nums, operations);
    }
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++){
            numsMap.put(nums[index], index);
        }

        for(int index = 0; index < operations.length; index++){
            if(numsMap.containsKey(operations[index][0])) {
                int placeIndex = numsMap.get(operations[index][0]);
                nums[placeIndex] = operations[index][1];
                numsMap.put(operations[index][1], placeIndex);
                numsMap.remove(operations[index][0]);
            }
        }

        return nums;
    }
}
