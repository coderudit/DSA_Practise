package com.dsa.app.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _740_DeleteAndEarn {
    public static void main(String[] args) {
        //int[] nums = {8,10,4,9,1,3,5,9,4,10};
        //int[] nums = {3, 4, 2};
        //int[] nums = {8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4};
        //int[] nums = {3, 1};
        int[] nums = {10000};
        System.out.println(deleteAndEarn2(nums));
    }

    public static int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int x : nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;
        for (int k = 0; k <= 10000; ++k)
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        return Math.max(avoid, using);
    }

    public static int deleteAndEarn2(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[max + 1];

        for (int x : nums) dp[x] += x;

        int prev = 0;
        int curr = dp[1];

        for (int k = 2; k <= max; k++) {
            int temp = curr;
            curr = Math.max(curr, prev + dp[k]);
            prev = temp;
        }
        return curr;
    }

    private static int delete(Map<Integer, Integer> numberOccurrences) {
        var mapSetIterator = numberOccurrences.entrySet().iterator();
        int[] numberSum = new int[numberOccurrences.size()];
        int sum = 0;

        var firstItem = mapSetIterator.next();
        numberSum[0] = firstItem.getKey() * firstItem.getValue();

        if (!mapSetIterator.hasNext())
            return numberSum[0];

        var secondItem = mapSetIterator.next();
        numberSum[1] = secondItem.getKey() * secondItem.getValue();

        if (secondItem.getKey() - 1 != firstItem.getKey()) {
            numberSum[1] += numberSum[0];
        }
        int prevValue = secondItem.getKey();
        for (int index = 2; index < numberOccurrences.entrySet().size(); index++) {
            var currentItem = mapSetIterator.next();
            int currentSum = currentItem.getKey() * currentItem.getValue();
            //if (currentItem.getKey() - 1 == prevValue)
            numberSum[index] = Math.max(currentSum + numberSum[index - 2], numberSum[index - 1]);
            // else
            // numberSum[index] = currentSum + numberSum[index - 1];

        }

        return numberSum[numberOccurrences.size() - 1];
    }

    /*private static int delete(Map<Integer, Integer> numberOccurrences, int max) {
        int sum = 0;
        while (max > 0) {
            if (numberOccurrences.containsKey(max - 1) && numberOccurrences.containsKey(max) && numberOccurrences.get(max - 1) > numberOccurrences.get(max)) {
                max = max - 1;
            }
            if (numberOccurrences.containsKey(max)) {
                int maxValue = numberOccurrences.get(max);
                numberOccurrences.replace(max, 0);
                sum += (maxValue * max);

                if (numberOccurrences.containsKey(max - 1) && numberOccurrences.get(max - 1) > 0) {
                    numberOccurrences.replace(max - 1, 0);
                }

                if (numberOccurrences.containsKey(max + 1) && numberOccurrences.get(max + 1) > 0) {
                    numberOccurrences.replace(max + 1, 0);
                }

                max = max - 2;
            } else {
                max = max - 1;
            }

        }
        return sum;
    }*/
}
