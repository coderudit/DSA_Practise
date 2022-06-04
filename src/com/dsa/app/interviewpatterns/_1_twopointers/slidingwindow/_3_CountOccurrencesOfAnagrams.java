package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

public class _3_CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        _3_CountOccurrencesOfAnagrams problem = new _3_CountOccurrencesOfAnagrams();
        String pattern = "for";
        String str = "forxxorfxdoofr";
        System.out.println(problem.anagramCount(pattern, str));
    }

    public int anagramCount(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = str.length();

        if (pLen == 0 || sLen == 0 || sLen < pLen)
            return 0;

        int charsCount = 256;
        int anaCount = 0;

        char[] pChars = new char[charsCount];
        char[] sChars = new char[charsCount];

        int index = 0;

        while (index < pLen) {
            pChars[charsCount - pattern.charAt(index)]++;
            sChars[charsCount - str.charAt(index)]++;
            index++;
        }

        if (Arrays.equals(pChars, sChars))
            anaCount++;

        while(index < sLen){
            sChars[charsCount - str.charAt(index - pLen)]--;
            sChars[charsCount - str.charAt(index)]++;
            index++;

            if (Arrays.equals(pChars, sChars))
                anaCount++;
        }

        return anaCount;
    }

}
