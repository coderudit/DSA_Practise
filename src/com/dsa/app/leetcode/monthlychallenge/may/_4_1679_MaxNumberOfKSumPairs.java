package com.dsa.app.leetcode.monthlychallenge.may;

import java.util.HashMap;
import java.util.Map;

public class _4_1679_MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        _4_1679_MaxNumberOfKSumPairs program = new _4_1679_MaxNumberOfKSumPairs();
        int[] nums = {1, 2, 3, 4};
        System.out.println(program.maxOperations(nums, 5));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.getOrDefault(k - num, 0) > 0) {
                res++;
                map.put(k - num, map.get(k - num) - 1);
            } else map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
