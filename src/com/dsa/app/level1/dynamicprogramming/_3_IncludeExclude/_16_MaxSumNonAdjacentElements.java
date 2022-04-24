package com.dsa.app.level1.dynamicprogramming._3_IncludeExclude;

import java.util.*;

public class _16_MaxSumNonAdjacentElements {
    public static void main(String[] args) {
        _16_MaxSumNonAdjacentElements program = new _16_MaxSumNonAdjacentElements();
        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        program.intersection(nums);
    }


    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int outerIndex = 0; outerIndex < 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < nums[outerIndex].length; innerIndex++) {
                numsMap.put(nums[outerIndex][innerIndex], 0);
            }
        }
        for (int outerIndex = 1; outerIndex < nums.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < nums[outerIndex].length; innerIndex++) {
                if (numsMap.containsKey(nums[outerIndex][innerIndex])) {
                    numsMap.put(nums[outerIndex][innerIndex], numsMap.get(nums[outerIndex][innerIndex]) + 1);
                }
            }
            var keys = numsMap.keySet().toArray();
            for (var key : keys) {
                if (numsMap.get(key) == 0) {
                    numsMap.remove(key);
                }
            }
            for (var key : numsMap.keySet()) {
                numsMap.put(key, 0);
            }
        }

        List<Integer> lst = new ArrayList<>();
        for (var key : numsMap.keySet()) {
            lst.add(key);
        }
        Collections.sort(lst);
        return lst;

    }

}
