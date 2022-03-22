package com.dsa.app.leetcode;

import java.util.ArrayList;
import java.util.List;

public class problem_29_1 {
    public static void main(String[] args) {
        int[] arr = {8, 19, 4, 2, 15, 3};
        problem_29_1 obj = new problem_29_1();
        obj.findFinalValue(arr, 2);
    }

    public int findFinalValue(int[] nums, int original) {

        int lastNum = original;
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            if (lastNum == nums[firstIndex])
            {
                lastNum *= 2;
                firstIndex = -1;
            }

        }
        return lastNum;
    }

}
