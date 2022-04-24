package com.dsa.app.level1.dynamicprogramming._3_IncludeExclude;

import java.util.ArrayList;
import java.util.List;

public class _14_DecodeWays {
    //private String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", ""};
    public static void main(String[] args) {
        _14_DecodeWays program = new _14_DecodeWays();
        String str = "21123";
        program.decodeWays2(str);
    }

    private void decodeWays2(String str) {
        int[] dp = new int[str.length()];
        dp[0] = 1;
        for (int index = 1; index < dp.length; index++) {
            if (str.charAt(index - 1) == '0' && str.charAt(index) == '0') {
                dp[index] = 0;
            } else if (str.charAt(index - 1) == '0' && str.charAt(index) != '0') {
                dp[index] = dp[index - 1];
            } else if (str.charAt(index - 1) != '0' && str.charAt(index) == '0') {
                if (str.charAt(index - 1) == '1' || str.charAt(index - 1) == '2') {
                    dp[index] = index >= 2 ? dp[index - 2] : 1;
                } else {
                    dp[index] = 0;
                }
            } else {
                if (Integer.parseInt(str.substring(index - 1, index + 1)) <= 26) {
                    dp[index] = dp[index - 1] + (index >= 2 ? dp[index - 2] : 1);
                } else {
                    dp[index] = dp[index - 1];
                }
            }
        }
        System.out.println(dp[str.length() - 1]);
    }

    private void decodeWays(String str) {
        int[] dp = new int[str.length()];
        List<String> decodeListPrev = new ArrayList<>();
        List<String> decodeListNew = new ArrayList<>();
        char ch = 'a';
        dp[0] = 1;
        decodeListPrev.add(String.valueOf(calculateChar(str.charAt(0))));
        for (int index = 1; index < dp.length; index++) {
            for (var element : decodeListPrev) {
                decodeListNew.add(element + calculateChar(str.charAt(index)));
            }
            for (var element : decodeListPrev) {
                int num = Integer.parseInt(str.substring(index - 1, index + 1));
                if (num <= 26)
                    decodeListNew.add(String.valueOf(calculateChar2(str.substring(index - 1, 2))));
            }
            decodeListPrev = decodeListNew;
            decodeListNew = new ArrayList<>();
        }
    }

    private char calculateChar(char ch) {
        return (char) (ch - 48 + 'a' - 1);
    }

    private char calculateChar2(String num) {
        return (char) (Integer.parseInt(num) + 96);

    }
}
