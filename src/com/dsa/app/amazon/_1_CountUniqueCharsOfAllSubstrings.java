package com.dsa.app.amazon;

import java.util.HashSet;

public class _1_CountUniqueCharsOfAllSubstrings {
    private int uniqueSum = 0;

    public static void main(String[] args) {
        _1_CountUniqueCharsOfAllSubstrings problem = new _1_CountUniqueCharsOfAllSubstrings();
        problem.countNumberOfSubstringsTillN("LEETCODE");
        //System.out.println(problem.uniqueLetterString("ABC"));
    }

    private void countNumberOfSubstringsTillN(String str) {
        int[] dp = new int[str.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= str.length(); index++) {
            dp[index] += (dp[index - 1] + index);
        }
        System.out.println(dp[str.length()]);
    }
}
