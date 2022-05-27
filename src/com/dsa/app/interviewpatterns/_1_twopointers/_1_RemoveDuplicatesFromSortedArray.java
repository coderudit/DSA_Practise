package com.dsa.app.interviewpatterns._1_twopointers;

public class _1_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        _1_RemoveDuplicatesFromSortedArray program = new _1_RemoveDuplicatesFromSortedArray();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        program.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[prev] == nums[index])
                continue;
            else {
                prev = prev + 1;
                nums[prev] = nums[index];
            }
        }
        return prev + 1;
    }
}
