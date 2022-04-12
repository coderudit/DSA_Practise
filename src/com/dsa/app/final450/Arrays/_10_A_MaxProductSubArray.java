package com.dsa.app.final450.Arrays;

public class _10_A_MaxProductSubArray {
    public static void main(String[] args) {
        _10_A_MaxProductSubArray obj = new _10_A_MaxProductSubArray();
        int[] nums = {-3, -1, -1};
        int[] nums1 = {-2, 3, -4};
        int[] nums2 = {0, 2};
        int[] nums3 = {-3, -2, 0, -1, -5, 6, 0, 2, 3};
        int[] nums4 = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(nums4));
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;

        int curMin = 1;
        int curMax = 1;

        for(int n : nums) {
            int temp = curMax * n;
            curMax = Math.max(n, Math.max(temp, n*curMin));
            curMin = Math.min(n, Math.min(temp, n*curMin));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
