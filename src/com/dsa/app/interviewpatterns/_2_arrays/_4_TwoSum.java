package com.dsa.app.interviewpatterns._2_arrays;

import java.util.HashMap;

public class _4_TwoSum {
    public static void main(String[] args) {
        _4_TwoSum problem = new _4_TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        problem.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];
            if (numsMap.containsKey(diff)) {
                return new int[]{index, numsMap.get(diff)};
            }
            numsMap.put(nums[index], index);
        }
        return null;
    }
}
