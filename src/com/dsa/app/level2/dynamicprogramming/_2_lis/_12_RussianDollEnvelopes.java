package com.dsa.app.level2.dynamicprogramming._2_lis;

import java.util.Arrays;

public class _12_RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        _12_RussianDollEnvelopes program = new _12_RussianDollEnvelopes();
        program.maxEnvelopes2(envelopes);
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));

        int[] dp = new int[envelopes.length];
        int overallMax = 0;
        for (int index = 0; index < envelopes.length; index++) {
            int max = 0;
            for (int innerIndex = 0; innerIndex < index; innerIndex++) {
                if (envelopes[innerIndex][0] < envelopes[index][0]
                        && envelopes[innerIndex][1] < envelopes[index][1]
                        && dp[innerIndex] > max) {
                    max = dp[innerIndex];
                }
            }
            dp[index] = max + 1;
            if (dp[index] > overallMax) {
                overallMax = dp[index];
            }
        }
        return overallMax;
    }

    public int maxEnvelopes2(int[][] A) {
        Arrays.sort(A, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] ans = new int[A.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int[] num : A) {
            int idx = Arrays.binarySearch(ans, num[1]);
            if (-idx - 1 < 0) continue;
            ans[-idx - 1] = num[1];
        }
        int i = 0;
        for (; i < ans.length && ans[i] != Integer.MAX_VALUE; i++) ;
        return i;
    }
}
