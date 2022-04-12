package com.dsa.app.final450.Arrays;

import java.util.HashSet;
import java.util.Set;

public class _14_PrefixSumSubArray {
    public static void main(String[] args) {
        _14_PrefixSumSubArray obj = new _14_PrefixSumSubArray();
        int[] arr = {4, 2, -3, 1, 6};
        int[] arr2 = {4, 2, 0, 1, 6};
        System.out.println(obj.isThereSubArrayWith0Sum(arr2));
    }

    private boolean isThereSubArrayWith0Sum(int[] arr) {
        Set<Integer> sumSet = new HashSet<>();
        int prevSum = 0;
        for (int index = 0; index < arr.length; index++) {
            prevSum += arr[index];
            if (sumSet.contains(prevSum))
                return true;
            else
                sumSet.add(prevSum);
        }
        return false;
    }

    private int isThereSubArrayWithKSum(int[] arr, int k) {
        Set<Integer> sumSet = new HashSet<>();
        int prevSum = 0;
        int count = 0;
        for (int index = 0; index < arr.length; index++) {
            prevSum += arr[index];
            if (sumSet.contains(prevSum) && prevSum == k)
                count++;
            else
                sumSet.add(prevSum);
        }
        return count;
    }
}
