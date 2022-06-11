package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _6_LongestSubarrayWithNonRepeatingChars {
    public static void main(String[] args) {
        _6_LongestSubarrayWithNonRepeatingChars problem = new _6_LongestSubarrayWithNonRepeatingChars();
        String str1 = "tmmzuxt";
        problem.lengthOfLongestSubstringOptimized(str1);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;

        int result = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            chars[currentChar]++;

            if (chars[currentChar] > 1) {
                while (chars[currentChar] > 1) {
                    chars[s.charAt(left)]--;
                    left++;
                }
            } else {
                result = Math.max(result, right - left + 1);
            }


            right++;
        }
        return result;
    }

    public int lengthOfLongestSubstringOptimized(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int right = 0;

        int result = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = Math.max(charMap.get(currentChar), left); //abba, math.max is for reverse string
            }

            result = Math.max(result, right - left + 1);
            charMap.put(currentChar, right + 1); //Starting index from 1 as space is also counted as 1 distinct character.
            right++;
        }
        return result;
    }
}
