package com.dsa.app.leetcode.contest291;

import java.util.HashMap;
import java.util.Map;

public class Program2 {
    public static void main(String[] args) {
        Program2 program = new Program2();
        int[] nums1 = {3, 4, 2, 3, 4, 7};
        int[] nums2 = {1, 0, 5, 3};
        int[] nums3 = {3, 4, 2, 3, 4, 3, 6, 7, 5, 3};
        System.out.println(program.minimumCardPickup(nums3));
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> numsSet = new HashMap<>();
        Map<Integer, Integer> diffsSet = new HashMap<>();
        for (int index = 0; index < cards.length; index++) {
            if (!numsSet.containsKey(cards[index])) {
                numsSet.put(cards[index], index);
            } else {
                int lastIndex = numsSet.get(cards[index]);
                if (!diffsSet.containsKey(cards[index])) {
                    diffsSet.put(cards[index], index - lastIndex);
                } else {
                    int prevDiff = diffsSet.get(cards[index]);
                    int currDiff = index - lastIndex;
                    if (currDiff < prevDiff) {
                        diffsSet.put(cards[index], currDiff);
                    }
                }
                numsSet.put(cards[index], index);
            }
        }

        if (diffsSet.size() == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (var key : diffsSet.keySet()) {
            min = Math.min(min, diffsSet.get(key));
        }
        return min + 1;
    }
}
