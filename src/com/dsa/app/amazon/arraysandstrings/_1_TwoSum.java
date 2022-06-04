package com.dsa.app.amazon.arraysandstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _1_TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for(int index = 0; index< nums.length; index++) {
            int diff = target - nums[index];
            if(numsMap.containsKey(diff) && numsMap.get(diff)!= index){
                return new int[] {index, numsMap.get(diff)};
            }
            numsMap.put(nums[index], index);
        }
        return null;
    }
}
