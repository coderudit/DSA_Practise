package com.dsa.app.final450.dynamicprogramming;

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
    }

    public static int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);

        for(int num=2; num < maxPoints.length; num++){
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num-2] + gain, maxPoints[num-1]);
        }

        return maxPoints[maxNumber];
    }

    public static int deleteAndEarnOptimized(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int twoBack = 0;
        int oneBack = points.getOrDefault(1, 0);

        for(int num=2; num <= maxNumber; num++){
            int temp = oneBack;
            int gain = points.getOrDefault(num, 0);
            oneBack = Math.max(twoBack + gain, oneBack);
            twoBack = temp;
        }

        return oneBack;
    }


}
