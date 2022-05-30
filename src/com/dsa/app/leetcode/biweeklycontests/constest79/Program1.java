package com.dsa.app.leetcode.biweeklycontests.constest79;

import java.util.HashMap;
import java.util.Map;

public class Program1 {
    public static void main(String[] args) {
        Program1 problem = new Program1();
        problem.digitCount("1210");

    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for (int index = 0; index < num.length(); index++) {
            int currentNum = num.charAt(index) - 48;
            if (!numsMap.containsKey(currentNum)) {
                numsMap.put(currentNum, 0);
            }
            numsMap.put(currentNum, numsMap.get(currentNum) + 1);
        }
        for (int index = 0; index < num.length(); index++) {
            int currentIndexCount = 0;
            if (numsMap.containsKey(index)) {
                currentIndexCount = numsMap.get(index);
            }
            if ((num.charAt(index) - 48) != currentIndexCount) {
                return false;
            }
        }
        return true;
    }
}
