package com.dsa.app.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class _438_findAllAnagramsInAString {

    int[] slidingWindowMap;
    int[] pMap;

    public static void main(String[] args) {
        _438_findAllAnagramsInAString obj = new _438_findAllAnagramsInAString();
        var lst = obj.findAnagrams("abab", "ab");
        for (int index = 0; index < lst.size(); index++) {
            System.out.println(lst.get(index));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        slidingWindowMap = new int[26];
        pMap = new int[26];

        //Count p frequency
        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }

        int start = 0, end = 0, k = p.length();
        List<Integer> lstInteger = new ArrayList<>();

        while (end < s.length()) {

            char curr = s.charAt(end);
            slidingWindowMap[curr - 'a']++;

            //For making sliding window
            if (end - start + 1 < k)
                end++;
            else {
                if (checkIfAnagram()) lstInteger.add(start);
                slidingWindowMap[s.charAt(start) - 'a']--;
                start++;
                end++;
            }
        }


        return lstInteger;
    }

    private boolean checkIfAnagram() {
        for (int index = 0; index < 26; index++) {
            if (slidingWindowMap[index] != pMap[index])
                return false;
        }
        return true;
    }
}
