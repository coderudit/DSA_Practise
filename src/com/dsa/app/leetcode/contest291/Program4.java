package com.dsa.app.leetcode.contest291;

public class Program4 {
    public static void main(String[] args) {
        Program4 program = new Program4();
        String str = "abbca";
        String str2 = "code";
        String str3 = "abcab";
        System.out.println(program.appealSumNew(str3));
    }

    public long appealSumNew(String s) {
        int n = s.length();
        long dp[] = new long[26];
        long temp = 1, count = 1;
        dp[s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            temp += (1 + i) - dp[s.charAt(i) - 'a'];
            dp[s.charAt(i) - 'a'] = i + 1;
            count += temp;

        }

        return count;
    }

    public long appealSum(String s) {
        int[][] dp = new int[s.length() + 1][s.length()];
        long sum = 0;
        for (int outerIndex = 0; outerIndex < dp.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < dp[0].length; innerIndex++) {
                if (outerIndex == 0) {
                    dp[outerIndex][innerIndex] = 1;
                    sum += 1;
                } else if (innerIndex < outerIndex) {
                    dp[outerIndex][innerIndex] = 0;
                } else {
                    if (s.substring(outerIndex - 1, innerIndex).indexOf(s.charAt(innerIndex)) != -1) {
                        dp[outerIndex][innerIndex] = dp[outerIndex][innerIndex - 1] == 0 ? 1 : dp[outerIndex][innerIndex - 1];
                    } else {
                        dp[outerIndex][innerIndex] = dp[outerIndex][innerIndex - 1] == 0 ? s.substring(outerIndex - 1, innerIndex).length() + 1 : dp[outerIndex][innerIndex - 1] + 1;
                    }
                    sum += dp[outerIndex][innerIndex];
                }
            }
        }
        return sum;
    }
}
