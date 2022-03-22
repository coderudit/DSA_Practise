package com.dsa.app.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem_29_2 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,0};
        problem_29_2 obj = new problem_29_2();
        obj.maxScoreIndices_(arr);
    }

    public List<Integer> maxScoreIndices_(int[] nums) {

        Map<Integer, Integer> dpRightMap = new HashMap<>();
        int dpRightSum = 0;


        for (int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] == 1)
                dpRightSum += 1;
            dpRightMap.put(index, dpRightSum);
        }
        dpRightMap.put(nums.length - 1, 0);
        dpRightMap.put(nums.length, 0);

        Map<Integer, Integer> dpLeftMap = new HashMap<>();
        int dpLeftSum = 0;
        dpLeftMap.put(0, dpLeftSum);
        for (int index = 1; index <= nums.length; index++) {
            if (nums[index - 1] == 0)
                dpLeftSum += 1;
            dpLeftMap.put(index, dpLeftSum);
        }

        int maxSum = 0;
        List<Integer> lst = new ArrayList<>();
        for (int index = 0; index <= nums.length; index++) {
            lst.add(dpLeftMap.get(index) + dpRightMap.get(index));
            if (maxSum < dpLeftMap.get(index) + dpRightMap.get(index)) {
                maxSum = dpLeftMap.get(index) + dpRightMap.get(index);
            }
        }

        List<Integer> newSst = new ArrayList<>();
       for (int index = 0; index < lst.size(); index++) {
           if(lst.get(index) == maxSum)
           newSst.add(index);
       }
        return newSst;


    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int prevSum = 0;
        List<Integer> numsBi = new ArrayList<>();


        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for (int index = 0; index <= nums.length; index++) {
            int leftSum = 0;
            int rightSum = 0;


            int left = 0;
            int right = nums[nums.length - 2];
            if (index != 0) {
                left = nums[index - 1];
                right = nums[nums.length - index - 2];
            }

            if (nums[left] == 0) {
                leftSum = 1;
            }
            if (nums[right] == 1) {
                rightSum = 1;
            }
            if (prevSum < leftSum + rightSum) {
                prevSum = leftSum + rightSum;
                if (index != 0) {
                    leftIndex = index - 1;
                    rightIndex = nums.length - index - 2;
                } else {
                    leftIndex = 0;
                    rightIndex = nums.length - 2;
                }
            }
        }
        numsBi.add(leftIndex);
        numsBi.add(rightIndex);
        return numsBi;
    }

}
