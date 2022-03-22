package com.dsa.app.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _697_DegreeOfAnArray {
    public static void main(String[] args) {
        _697_DegreeOfAnArray obj = new _697_DegreeOfAnArray();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(obj.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap(), left = new HashMap<>(), right = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            if(!left.containsKey(value))
                left.put(value, index);
            right.put(value, index);
            count.compute(nums[index], (k, v) -> v == null ? 1 : v + 1);
        }

        int degree = Collections.max(count.values());

        int ans = nums.length;
        for(int key: count.keySet()){
            if(count.get(key) == degree)
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
        }

        return ans;

    }
}
