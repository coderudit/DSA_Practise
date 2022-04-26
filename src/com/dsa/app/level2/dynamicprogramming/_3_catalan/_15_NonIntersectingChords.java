package com.dsa.app.level2.dynamicprogramming._3_catalan;

public class _15_NonIntersectingChords {
    public static void main(String[] args) {

    }
    private void getCatalanNumber(int c) {
        int num = c/2;
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index < dp.length; index++) {
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                dp[index] += dp[innerIndex] * dp[index - innerIndex - 1];
            }
        }
        System.out.println(dp[num]);
    }
}
