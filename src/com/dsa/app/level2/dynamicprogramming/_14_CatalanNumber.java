package com.dsa.app.level2.dynamicprogramming;

public class _14_CatalanNumber {
    public static void main(String[] args) {
        _14_CatalanNumber program = new _14_CatalanNumber();
        program.getCatalanNumber(12);
    }

    private void getCatalanNumber(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index < dp.length; index++) {
            for(int innerIndex = 0; innerIndex < index; innerIndex++) {
                dp[index] += dp[innerIndex] * dp[index-innerIndex-1];
            }
        }
        System.out.println(dp[num]);
    }
}
