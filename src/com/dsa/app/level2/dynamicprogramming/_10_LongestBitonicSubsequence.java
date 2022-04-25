package com.dsa.app.level2.dynamicprogramming;

public class _10_LongestBitonicSubsequence {
    public static void main(String[] args) {
        _10_LongestBitonicSubsequence program = new _10_LongestBitonicSubsequence();
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        program.findLongestBitonicSubsequence(nums);
    }

    private void findLongestBitonicSubsequence(int[] nums) {
        //Stores the  longest subsequence till that index with that number as the last.
        int[] lis = new int[nums.length];
        int max = 0;
        for (int index = 0; index < lis.length; index++) {
            max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (nums[innerIndex] < nums[index] && lis[innerIndex] > max) {
                    max = lis[innerIndex];
                }
            }
            lis[index] = max + 1;
        }

        int[] lds = new int[nums.length];
        for (int index = lds.length - 1; index >= 0; index--) {
            max = 0;
            for (int innerIndex = lds.length - 1; innerIndex > index; innerIndex--) {
                if (nums[innerIndex] <= nums[index] && lds[innerIndex] > max) {
                    max = lds[innerIndex];
                }
            }
            lds[index] = max + 1;
        }

        int omax = 0;
        for (int index = 0; index < lis.length; index++) {
            if (lis[index] + lds[index] - 1 > omax) {
                omax = lis[index] + lds[index] - 1;
            }
        }
        System.out.println(omax);
    }
}
