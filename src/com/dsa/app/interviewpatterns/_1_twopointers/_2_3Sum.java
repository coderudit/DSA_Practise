package com.dsa.app.interviewpatterns._1_twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _2_3Sum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length && nums[index] <= 0; index++) {

        }
        return result;
    }

    public void twoSum(int[] nums, int target, List<List<Integer>> result) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];
            if (numsMap.containsKey(diff)) {
                result.add(Arrays.asList(index, numsMap.get(diff), target));
            }
            numsMap.put(nums[index], index);
        }
    }
}
