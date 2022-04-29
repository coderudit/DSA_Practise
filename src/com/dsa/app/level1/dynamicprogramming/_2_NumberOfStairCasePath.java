package com.dsa.app.level1.dynamicprogramming;

public class _2_NumberOfStairCasePath {
    public static void main(String[] args) {
        int num = 5;
        int[] countPathsArr = new int[num + 1];
        int paths = countPathsWithMemoization(num, countPathsArr);
        int paths2 = countPathsWithTabulation(num);
        System.out.println(paths);
        System.out.println(paths2);
    }

    public static int countPathsWithMemoization(int num, int[] countPathsArr) {
        if (num == 0)
            return 1;
        else if (num < 0)
            return 0;

        if (countPathsArr[num] > 0)
            return countPathsArr[num];

        int countPaths1 = countPathsWithMemoization(num - 1, countPathsArr);
        int countPaths2 = countPathsWithMemoization(num - 2, countPathsArr);
        int countPaths3 = countPathsWithMemoization(num - 3, countPathsArr);
        countPathsArr[num] = countPaths1 + countPaths2 + countPaths3;
        return countPaths1 + countPaths2 + countPaths3;
    }

    /* We want to find number of paths available from 0 to n.
     * dp[n] stores number of ways to reach from 0 to n.
     */
    public static int countPathsWithTabulation(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        for (int index = 1; index <= num; index++) {
            dp[index] = dp[index - 1];

            if (!(index - 2 < 0))
                dp[index] += dp[index - 2];

            if (!(index - 3 < 0))
                dp[index] += dp[index - 3];
        }
        return dp[num];
    }

}
