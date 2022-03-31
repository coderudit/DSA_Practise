package com.dsa.app.leetcode.contest286;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        int[] nums1 = {1, 1, 2, 3, 5};//1
        int[] nums2 = {1, 1, 2, 2, 3, 3};//2
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};//12
        int[] nums4 = {1, 1, 1, 1, 2, 2, 2, 2};//6
        int[] nums5 = {1, 1, 1, 1};//4
        int[] nums7 = {2, 8, 1, 2, 1, 0, 5, 1, 8};//1
        int[] nums8 = {8, 8, 1, 3, 2, 0, 1, 2, 5, 0};//2
        int[] nums9 = {8};//1
        //System.out.println(obj.minDeletionExtended3(nums2));
        System.out.println(obj.minDeletionExtended(nums1));
        System.out.println(obj.minDeletionExtended(nums2));
        System.out.println(obj.minDeletionExtended(nums3));
        System.out.println(obj.minDeletionExtended(nums4));
        System.out.println(obj.minDeletionExtended(nums5));
        System.out.println(obj.minDeletionExtended(nums7));
        System.out.println(obj.minDeletionExtended(nums8));
        System.out.println(obj.minDeletionExtended(nums9));
    }

    public int minDeletionExtended3(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Stack<Integer> numStack = new Stack<>();

        int deletedElements = 0;
        for (int index = 0; index < nums.length; index++) {
            if (numStack.size() % 2 == 1 && numStack.peek() == nums[index])
                deletedElements++;
            else
                numStack.push(nums[index]);
        }

        if (nums.length % 2 == 0) {
            if (numStack.size() % 2 == 1)
                return deletedElements + 1;
        } else {
            if (numStack.size() % 2 == 1)
                return deletedElements + 1;
        }
        return deletedElements;
    }

    public int minDeletionExtended(int[] nums) {

        int er = 0;
        int or = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            if (index % 2 == 0 && nums[index] == nums[index + 1]) {
                er++;
            } else if (index % 2 == 1 && nums[index] == nums[index + 1]) {
                or++;
            }
        }

        int fv = er + or;
        if (fv == 0)
            return nums.length % 2 == 0 ? 0 : 1;
        if (fv == nums.length - 1 && nums.length % 2 == 0)
            return nums.length;
        else //(fv == nums.length - 1 && nums.length % 2 == 1)
            return nums.length;
        /*if (nums.length % 2 == 0 && fv % 2 != 0)
            return er + or - 1;
        else
            return er + or;*/
    }

    public int minDeletion(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            if (!numMap.containsKey(nums[index])) {
                numMap.put(nums[index], 0);
            }
            numMap.computeIfPresent(nums[index], (k, v) -> v + 1);
        }

        int repetitiveElements = 0;
        for (var key : numMap.keySet()) {
            repetitiveElements += (numMap.get(key) - 1);
        }

        if (nums.length % 2 == 1) {
            if (repetitiveElements % 2 == 0) {
                if (repetitiveElements == 0)
                    repetitiveElements = 1;
            }

        } else {

            if (repetitiveElements % 2 == 1) {
                if (repetitiveElements == nums.length - 1) {
                    repetitiveElements = nums.length;
                } else {
                    repetitiveElements -= 1;
                }
            }
        }
        return repetitiveElements;
    }

}
