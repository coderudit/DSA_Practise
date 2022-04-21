package com.dsa.app.level1.dynamicprogramming;

public class _3_NumberOfStairCasePathWithJumps {
    public static void main(String[] args) {
        int[] varPathsArr2 = {3, 3, 0, 2, 2, 3};
        int numberOfPaths3 = countNumberOfPathsTabulation(varPathsArr2);
        System.out.println(numberOfPaths3);
    }

    /* We want to find number of paths available from n to 0.
     * dp[n] stores number of ways to reach from n to 0.
     */
    private static int countNumberOfPathsTabulation(int[] varPathsArr) {
        if (varPathsArr.length <= 1)
            return 1;

        int[] dp = new int[varPathsArr.length + 1];
        dp[varPathsArr.length] = 1;
        for (int i = varPathsArr.length - 1; i >= 0; i--) {
            for (int index = 1; index <= varPathsArr[i] && i + index <= varPathsArr.length; index++) {
                dp[i] += dp[i + index];
            }
        }
        return dp[0];
    }

}
