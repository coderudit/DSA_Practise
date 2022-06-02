package com.dsa.app.amazon;

public class _7_MaximumSecurity {
    public static void main(String[] args) {

    }

    public int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int[] newNums = new int[nums.length-1];
        for(int index = 0; index < newNums.length; index++){
            newNums[index] = (nums[index] + nums[index+1]) % 10;
        }

        return triangularSum(newNums);
    }
}
