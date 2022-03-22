package com.dsa.app.leetcode.contest280;


import java.util.*;

public class program2 {
    public static void main(String[] args) {
        program2 obj = new program2();
        //int[] nums = {3, 1, 3, 2, 4, 3};
        //int[] nums2 = {1,2,2,2,2};
        //int[] nums3 = {2,1,1,1,1};
        //int[] nums4= {14,57,66,52,43,23,52,29,91,9,6,62,1,23,6,33,17,25,98,6,1,64,73,37,44,81,78,75,79,70,25,19,24,18,3,14,31,21,14,66,79,63,100,12,30,32,21,54,9,85,92,49,50,26,25,19,41,94,1,74,99,98,92,24,82,47,25,36,80,50,21,95,90,78,54,67,54,52,14,4,36,38,71,90,13,17,95,97,62,96};
        int[] nums5 = {1, 1};
        System.out.println((obj.minimumOperations(nums5)));
    }

    public int minimumOperations(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        if (nums.length <= 2) {
            if (nums[0] == nums[1])
                return 1;
            else
                return 0;
        }

        Map<Integer, Integer> countAt2 = new HashMap<>();
        Map<Integer, Integer> countAt1 = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (index % 2 == 0) {
                countAt2.compute(nums[index], (key, val) -> val == null ? 1 : val + 1);
            } else {
                countAt1.compute(nums[index], (key, val) -> val == null ? 1 : val + 1);
            }
        }
        int max2 = Collections.max(countAt2.values());
        int max1 = Collections.max(countAt1.values());

        for (var key : countAt2.entrySet()) {  // Iterate through HashMap
            if (key.getValue() == max2) {
                max2 = Integer.valueOf(String.valueOf(key.getKey()));
                break;// Print the key with max value
            }
        }

        for (var key : countAt1.entrySet()) {  // Iterate through HashMap
            if (key.getValue() == max1) {
                max1 = Integer.valueOf(String.valueOf(key.getKey()));
                break;// Print the key with max value
            }
        }

        if (max1 == max2) {
            if (countAt2.get(max2) <= countAt1.get(max1) && countAt2.keySet().size() > 1) {
                countAt2.put(max2, 0);
                max2 = Collections.max(countAt2.values());
                for (var key : countAt2.entrySet()) {  // Iterate through HashMap
                    if (key.getValue() == max2) {
                        max2 = Integer.valueOf(String.valueOf(key.getKey()));     // Print the key with max value
                    }
                }
            } else {
                countAt1.put(max1, 0);
                max1 = Collections.max(countAt1.values());
                for (var key : countAt1.entrySet()) {  // Iterate through HashMap
                    if (key.getValue() == max1) {
                        max1 = Integer.valueOf(String.valueOf(key.getKey()));     // Print the key with max value
                    }
                }
            }
        }

        int numOperations = 0;
        int max2Value = countAt2.get(max2);
        numOperations = (int) (Math.ceil(nums.length / 2)) - max2Value;
        int max1Value = countAt1.get(max1);
        numOperations += (int) (Math.ceil(nums.length / 2)) - max1Value;
        if (nums.length % 2 != 0)
            numOperations++;
        return numOperations;
    }

}
