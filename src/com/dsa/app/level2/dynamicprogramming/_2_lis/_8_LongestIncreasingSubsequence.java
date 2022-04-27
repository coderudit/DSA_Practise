package com.dsa.app.level2.dynamicprogramming._2_lis;

import java.util.ArrayDeque;

public class _8_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        _8_LongestIncreasingSubsequence program = new _8_LongestIncreasingSubsequence();
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        //program.findLongestIncreasingSubsequence(nums);
        program.printLongestIncreasingSubsequence(nums);
    }

    /*
     * This is not the best way to solve LIS as it takes O(n * n) time.
     * Best one can be achieved through binary search with O(n * log n) time.
     * */
    private void findLongestIncreasingSubsequence(int[] nums) {
        //Stores the longest subsequence till that index with current number as the last.
        //Because if it stores the longest subsequence till that index with any number as the last,
        //it won't be confident enough to compare with the value and tell that it can come after that.
        //e.g: 50, 41, 49 => At 41 we will store 50 as the last if we don't go by rules and 49 when comparing
        //with 41 has a dilemma that even if it's larger than 41 whether it is larger than the largest value
        //stored inside that but with rules we are sure we have to compare with only 41.
        int[] dp = new int[nums.length];
        int overallMax = 0;
        for (int index = 0; index < dp.length; index++) {
            int max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                //This ensures we get only those numbers that are smaller than the current number.
                if (nums[innerIndex] < nums[index] && dp[innerIndex] > max) {
                    max = dp[innerIndex];
                }
            }
            dp[index] = max + 1;
            if (dp[index] > overallMax) {
                overallMax = dp[index];
            }
        }
        System.out.println(overallMax);
    }

    /*
     * Implement using queue and reverse engineering on the stored values.
     * Time complexity: Number of solutions * n
     * */
    private void printLongestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        int overallMax = 0;
        for (int index = 0; index < dp.length; index++) {
            int max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                //This ensures we get only those numbers that are smaller than the current number.
                if (nums[innerIndex] < nums[index] && dp[innerIndex] > max) {
                    max = dp[innerIndex];
                }
            }
            dp[index] = max + 1;
            if (dp[index] > overallMax) {
                overallMax = dp[index];
            }
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int startIndex = 0; startIndex < dp.length; startIndex++) {
            if (overallMax == dp[startIndex])
                queue.add(new Pair(overallMax, startIndex, nums[startIndex], nums[startIndex] + " "));
        }

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (rem.length == 1) {
                System.out.println(rem.psf);
            }

            for (int startIndex = rem.index - 1; startIndex >= 0; startIndex--) {
                if (dp[startIndex] == rem.length - 1 && rem.value >= nums[startIndex]) {
                    queue.add(new Pair(rem.length - 1, startIndex, nums[startIndex], nums[startIndex] + " -> " + rem.psf));
                }
            }
        }
        System.out.println(overallMax);
    }
}

class Pair {
    int length;
    int index;
    int value;
    String psf;

    public Pair(int length, int index, int value, String psf) {
        this.length = length;
        this.index = index;
        this.value = value;
        this.psf = psf;
    }
}
