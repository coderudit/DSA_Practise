package com.dsa.app.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1_CountUniqueCharsOfAllSubstrings {
    private int uniqueSum = 0;

    public static void main(String[] args) {
        _1_CountUniqueCharsOfAllSubstrings problem = new _1_CountUniqueCharsOfAllSubstrings();
        problem.findSubstrings("LEETCODE");
        //problem.countNumberOfSubstringsTillN("LEETCODE");
        //System.out.println(problem.uniqueLetterString("ABC"));
    }

    /*Brute force appraoch:
    * Step 1: Find the substrings
    * Step 2: Find the unique characters using substrings*/
    private void findSubstrings(String str) {
        int finalUniqueChars = 0;
        for (int firstIndex = 0; firstIndex < str.length(); firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex <= str.length(); secondIndex++) {
                //System.out.println(str.substring(firstIndex, secondIndex));
                finalUniqueChars += countUniqueChars(str.substring(firstIndex, secondIndex));
                //System.out.println(finalUniqueChars);
            }
        }
        //System.out.println(finalUniqueChars);
    }

    private int countUniqueChars(String str) {
        int uniqueCount = 0;
        HashSet<Character> hashSet = new HashSet<>();
        HashSet<Character> foundHashSet = new HashSet<>();
        for (int index = 0; index < str.length(); index++) {
            if (!hashSet.contains(str.charAt(index))) {
                hashSet.add(str.charAt(index));
                uniqueCount++;
            } else {
                if (!foundHashSet.contains(str.charAt(index))) {
                    foundHashSet.add(str.charAt(index));
                    uniqueCount -= 1;
                }
            }
        }

        return uniqueCount;
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
