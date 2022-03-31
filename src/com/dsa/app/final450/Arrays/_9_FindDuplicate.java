package com.dsa.app.final450.Arrays;

public class _9_FindDuplicate {
    public static void main(String[] args) {
        _9_FindDuplicate obj = new _9_FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(obj.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
