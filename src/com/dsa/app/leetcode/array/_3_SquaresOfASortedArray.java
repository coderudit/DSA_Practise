package com.dsa.app.leetcode.array;

public class _3_SquaresOfASortedArray {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        int[] tempArr = new int[nums.length];
        int currentIndex = nums.length - 1;

        int start = 0;
        int end = nums.length - 1;

        while (currentIndex >= 0) {
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                tempArr[currentIndex] = nums[start] * nums[start];
                start++;
            }else{
                tempArr[currentIndex] = nums[end] * nums[end];
                end--;
            }
            currentIndex--;
        }
        return tempArr;
    }
}
