package com.dsa.app.leetcode.array;


import java.util.HashMap;
import java.util.Map;

public class _454_ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 1};
        _454_ContiguousArray obj = new _454_ContiguousArray();
        obj.findMaxLength(nums);
    }

    public int findMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prevMax = 0;
        int start = 0;
        for (int index = 1; index < nums.length; index++) {
            if ((nums[index - 1] ^ nums[index]) == 1) {
                if ((index - start + 1) % 2 == 0 && prevMax < index - start + 1) {
                    prevMax = index - start + 1;
                }

            } else {
                start = index;
            }
        }
        return prevMax;
    }

    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        int maxLen = 0;
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            count += nums[index] == 0 ? -1 : 1;
            if (numsMap.containsKey(count))
                maxLen = Math.max(maxLen, index - numsMap.get(count));
            else
                numsMap.put(count, index);
        }
        return maxLen;
    }
}
