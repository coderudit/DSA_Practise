package com.dsa.app.level1.dynamicprogramming;

public class _7_TargetSumSubsets {
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        _7_TargetSumSubsets obj = new _7_TargetSumSubsets();

        int set2[] = {4, 2, 7, 1, 3};
        int sum2 = 10;
        System.out.println(obj.targetSumSubsets(set2, sum2));
        //System.out.println(obj.targetSumSubsetsModified(set2, sum2));
    }

    // It uses 2 dimensional array, as state previous to the current state can only
    // be get through it. Single array can be beneficial only when we can use a number
    // more than once, like in coin change problem.
    private boolean targetSumSubsets(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        //With given values what scores can we make.
        for (int arrIndex = 0; arrIndex < dp.length; arrIndex++) {
            for (int scoreIndex = 0; scoreIndex < dp[0].length; scoreIndex++) {
                if (arrIndex == 0 && scoreIndex == 0) {
                    dp[arrIndex][scoreIndex] = true;
                } else if (arrIndex == 0) {
                    dp[arrIndex][scoreIndex] = false;
                } else if (scoreIndex == 0) {
                    dp[arrIndex][scoreIndex] = true;
                } else {//Current score can be achieved without including current element
                    if (dp[arrIndex - 1][scoreIndex]) {
                        dp[arrIndex][scoreIndex] = true;
                    } else {//Current score can be achieved by including current element if and only if the previous sum was subtraction of it from the current sum.
                        int value = arr[arrIndex - 1];//value of the current element is stored at this location
                        if (scoreIndex >= value) { //value should be greater than the
                            // current number then, only this number can be included.
                            if (dp[arrIndex - 1][scoreIndex - value]) {
                                // if the value at column equals to score - value is true
                                dp[arrIndex][scoreIndex] = true;
                            }
                        }

                    }
                }

            }
        }

        return dp[arr.length][sum];
    }

    private boolean targetSumSubsetsModified(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        //With given values what scores can we make.
        for (int arrIndex = 0; arrIndex < arr.length; arrIndex++) {
            int value = arr[arrIndex];
            for (int scoreIndex = 1; scoreIndex <= sum; scoreIndex++) {
                if (!dp[scoreIndex]) {
                    if (scoreIndex >= value) {
                        if (dp[scoreIndex - value]) {
                            dp[scoreIndex] = true;
                        }
                    }

                }
            }
        }
        return dp[sum];
    }
}