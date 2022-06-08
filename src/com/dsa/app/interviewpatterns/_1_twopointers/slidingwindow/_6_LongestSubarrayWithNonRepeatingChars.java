package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _6_LongestSubarrayWithNonRepeatingChars {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;

        int result = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            chars[currentChar]++;


            while (chars[currentChar] > 1) {
                chars[s.charAt(left)]--;
                left++;
            }

            result = Math.max(result, right - left + 1);
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
                left = Math.max(charMap.get(currentChar), left);
            }

            result = Math.max(result, right - left + 1);
            charMap.put(currentChar, right + 1);
            right++;
        }
        return result;
    }
}
