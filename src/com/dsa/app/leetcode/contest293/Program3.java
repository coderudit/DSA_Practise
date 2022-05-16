package com.dsa.app.leetcode.contest293;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Program3 {
    public static void main(String[] args) {
        Program3 program = new Program3();
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(program.largestCombination(candidates));
    }

    public int largestCombination(int[] candidates) {
        String binaryValue = "0000000000000000000000000";
        Map<Integer, Integer> binaryMap = new HashMap<>();
        for (int index = binaryValue.length() - 1; index >= 0; index--) {
            binaryMap.put(index, 0);
        }

        for (int index = 0; index < candidates.length; index++) {
            var binaryNum = Integer.toBinaryString(candidates[index]);
            fillBinaryAndCount(binaryNum, binaryMap);
        }

        Map.Entry<Integer, Integer> maxEntry = Collections.max(binaryMap.entrySet(), (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));

        return maxEntry.getValue();
    }

    private void fillBinaryAndCount(String binaryNum, Map<Integer, Integer> binaryMap) {
        for (int index = 0; index < binaryNum.length(); index++) {
            //System.out.println(binaryNum.charAt(index));
            if (binaryNum.charAt(index) == '1') {
                int currentIndex = binaryNum.length() - 1 - index;
                binaryMap.put(currentIndex, binaryMap.get(currentIndex) + 1);
            }
        }
    }
}
