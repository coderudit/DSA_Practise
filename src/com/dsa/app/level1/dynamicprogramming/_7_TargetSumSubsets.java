package com.dsa.app.level1.dynamicprogramming;

public class _7_TargetSumSubsets {
    public static void main(String[] args) {

    }

    private boolean targetSumSubsets(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int arrIndex = 0; arrIndex < dp.length; arrIndex++) {
            for (int scoreIndex = 0; scoreIndex < dp[0].length; scoreIndex++) {
                if (arrIndex == 0 && scoreIndex == 0) {
                    dp[arrIndex][scoreIndex] = true;
                } else if (arrIndex == 0) {
                    dp[arrIndex][scoreIndex] = false;
                } else if (scoreIndex == 0) {
                    dp[arrIndex][scoreIndex] = true;
                } else {
                    if (dp[arrIndex - 1][scoreIndex]) {
                        dp[arrIndex][scoreIndex] = true;
                    } else {
                        int value = arr[arrIndex - 1];//value is stored at this location
                        if (value >= scoreIndex) { //value should be greater than the
                            // current number then, only this number can be included.
                            if (dp[arrIndex - 1][scoreIndex - value] == true) {
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

}
