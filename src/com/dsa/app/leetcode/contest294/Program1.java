package com.dsa.app.leetcode.contest294;

import java.util.HashMap;
import java.util.Map;

public class Program1 {
    public static void main(String[] args) {
        Program1 program = new Program1();
        String s= "foobar";
        char letter = 'o';
        System.out.println(program.percentageLetter(s, letter));
    }

    public int percentageLetter(String s, char letter) {
        int[] charArr = new int[26];
        for(int index = 0; index < s.length(); index++){
            int currentIndex = s.charAt(index) - 'a';
            charArr[currentIndex] = charArr[currentIndex] + 1;
        }

        int findIndex = letter - 'a';
        int value = charArr[findIndex];
        int finalPercentage = (value * 100)/ s.length();
        return finalPercentage;
    }

}
