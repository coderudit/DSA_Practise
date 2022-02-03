package com.dsa.app.final450.Arrays;

public class _1_RotateAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        _1_RotateAnArray obj = new _1_RotateAnArray();
        int k = 15;
        k = k % arr.length;
        obj.rotateLeftByReversalAlgorithm(arr, k);
        obj.rotateRightByReversalAlgorithm(arr, k);
    }

    public void rotateLeftByReversalAlgorithm(int[] nums, int k) {
        k = k % nums.length;        //If k>nums.length e.g. nums=[-1], k=2, then k=2%1 which is k=0. Since multiple rotations that are divisible by nums.length will form same result.

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public void rotateRightByReversalAlgorithm(int[] nums, int k) {
        k = k % nums.length;        //If k>nums.length e.g. nums=[-1], k=2, then k=2%1 which is k=0. Since multiple rotations that are divisible by nums.length will form same result.

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
