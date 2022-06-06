package com.dsa.app.leetcode.contest296;


public class Program1 {
    public static void main(String[] args) {
        Program1 problem = new Program1();
        int[] nums = {1, 3, 5, 2, 4, 8, 2};
        problem.minMaxGame(nums);
    }

    public int minMaxGame(int[] nums) {

        int[] newNums = new int[nums.length / 2];
        int totalSize = nums.length;
        int newIndex = 0;
        while (totalSize > 1) {
            for (int index = 0; index < totalSize; index += 4) {
                newNums[newIndex++] = Math.min(nums[index], nums[index + 1]);
                if (index + 2 < totalSize && index + 3 < totalSize)
                    newNums[newIndex++] = Math.max(nums[index + 2], nums[index + 3]);
                else if (index + 2 < totalSize) {
                    newNums[newIndex++] = nums[index + 2];
                }
            }

            totalSize = totalSize / 2;
            for (int index = 0; index < totalSize; index++) {
                nums[index] = newNums[index];
            }
            newIndex = 0;

        }

        return nums[0];
    }
}
