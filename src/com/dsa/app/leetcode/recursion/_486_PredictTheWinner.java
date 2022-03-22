package com.dsa.app.leetcode.recursion;

public class _486_PredictTheWinner {
    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        _486_PredictTheWinner obj = new _486_PredictTheWinner();
        //System.out.println(obj.PredictTheWinner(nums));
    }

    /*public boolean PredictTheWinner(int[] nums) {
        return pickTheNumber(0, 0, nums, 0, nums.length - 1, true);
    }

    private boolean pickTheNumber(int[] nums) {
        int totalSum1 = 0;
        int totalSum2 = 0;

        int leftIndex = 0;
        int rightIndex = 0;
        boolean player1Turn = false;

        if (nums.length % 2 == 0) {
            leftIndex = nums.length / 2 - 1;
            rightIndex = nums.length / 2;
        } else {
            leftIndex = nums.length / 2;
            rightIndex = nums.length / 2;
        }




        while (leftIndex >= 0 && rightIndex <= nums.length - 1) {
            if ( boolean)
        }
    }*/


    /*private boolean pickTheNumber(int totalSum1, int totalSum2, int[] nums, int leftIndex, int rightIndex, boolean player1Turn) {

        if ((rightIndex - leftIndex) == 0) {
            if (totalSum1 >= totalSum2)
                return true;
            else
                return false;
        }

        boolean result = false;
        if (player1Turn) {
            if (nums[leftIndex] > nums[rightIndex]) {
                totalSum1 += nums[leftIndex];
                result = pickTheNumber(totalSum1, totalSum2, nums, leftIndex + 1, rightIndex, !player1Turn);
            } else {
                totalSum1 += nums[rightIndex];
                result = pickTheNumber(totalSum1, totalSum2, nums, leftIndex, rightIndex - 1, !player1Turn);
            }
        } else {
            if (nums[leftIndex] > nums[rightIndex]) {
                totalSum2 += nums[leftIndex];
                result = pickTheNumber(totalSum1, totalSum2, nums, leftIndex + 1, rightIndex, !player1Turn);
            } else {
                totalSum2 += nums[rightIndex];
                result = pickTheNumber(totalSum1, totalSum2, nums, leftIndex, rightIndex - 1, !player1Turn);
            }
        }
        if (result) {
            return true;
        }
        return false;
    }*/

}
