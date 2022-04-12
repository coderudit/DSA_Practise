package com.dsa.app.final450.Arrays;

import java.util.HashSet;
import java.util.Set;

public class _12_FindAllPairsWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 1};
        int[] nums1 ={1, 1, 1, 1};
        int sum = 2;
        _12_FindAllPairsWithGivenSum obj = new _12_FindAllPairsWithGivenSum();
        System.out.println(obj.FindSumPairs(nums1, sum));
    }

    public int FindSumPairs(int[] nums, int sum) {
        Set<Integer> numsMap = new HashSet<>();
        int pairsCount=0;
        for(int index = 0; index < nums.length; index++){
            if(numsMap.contains(sum - nums[index])){
                pairsCount+=2;
            }else {
                numsMap.add(nums[index]);
            }
        }
        return pairsCount;
    }
}
