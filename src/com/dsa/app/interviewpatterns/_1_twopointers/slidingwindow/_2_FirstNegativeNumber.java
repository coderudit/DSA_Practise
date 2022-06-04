package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class _2_FirstNegativeNumber {
    public static void main(String[] args) {
        _2_FirstNegativeNumber problem = new _2_FirstNegativeNumber();
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        var negList = problem.firstNegativeNumber(3, nums);

        System.out.println(negList.toString());
    }

    public List<Integer> firstNegativeNumber(int k, int[] nums) {
        List<Integer> negIndexes = new ArrayList<>();
        int currNegIndex = -1;
        for (int index = 0; index < k; index++) {
            if (nums[index] < 0) {
                currNegIndex = index;
                negIndexes.add(nums[index]);
                break;
            }
        }

        for (int index = k; index < nums.length; index++) {
            int startSliding = index - k + 1;
            if (startSliding <= currNegIndex) {
                negIndexes.add(nums[currNegIndex]);
            } else {
                boolean negFound = false;
                while (startSliding <= index) {
                    if (nums[startSliding] < 0) {
                        currNegIndex = startSliding;
                        negIndexes.add(nums[startSliding]);
                        negFound = true;
                        break;
                    }
                    startSliding++;
                }
                if (!negFound)
                    negIndexes.add(-1);
            }
        }

        return negIndexes;
    }
}
