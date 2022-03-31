package com.dsa.app.leetcode.contest286;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        obj.findDifference(nums1, nums2);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1List = new HashSet<>();
        Set<Integer> num2List = new HashSet<>();
        boolean isInB = false;
        boolean isInA = false;
        for(int num1Index = 0; num1Index < nums1.length; num1Index++){
            for(int num2Index = 0; num2Index < nums2.length; num2Index++){
                if(nums1[num1Index] == nums2[num2Index]){
                    isInB = true;
                    break;
                }
            }
            if(!isInB){
                num1List.add(nums1[num1Index]);
            }
            isInB = false;
        }

        for(int num2Index = 0; num2Index < nums2.length; num2Index++){
            for(int num1Index = 0; num1Index < nums1.length; num1Index++){
                if(nums1[num1Index] == nums2[num2Index]){
                    isInA = true;
                    break;
                }
            }
            if(!isInA){
                num2List.add(nums2[num2Index]);
            }
            isInA = false;
        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(num1List.stream().toList());
        list.add(num2List.stream().toList());

        return list;
    }
}
