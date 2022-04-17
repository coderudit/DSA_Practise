package com.dsa.app.leetcode.contest289;

import java.util.HashMap;
import java.util.Map;

public class Program2 {
    public static void main(String[] args) {
        Program2 program = new Program2();
        int[] tasks1 = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int[] tasks2 = {2, 3, 3};
        int[] tasks3 = {5, 5, 5, 5};
        int[] tasks4 = {66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61};
        //System.out.println(program.minimumRounds(tasks4));
    }

    private Map<Integer, Integer> dp = new HashMap<>();

    /**
     * If freq = 1, not possible, return -1
     * If freq = 2, needs one 2-tasks
     * If freq = 3, needs one 3-tasks
     * If freq = 3k, freq = 3 * k, needs k batchs.
     * If freq = 3k + 1, freq = 3 * (k - 1) + 2 + 2, needs k + 1 batchs.
     */

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> numsCount = new HashMap<>();

        for (int index = 0; index < tasks.length; index++) {
            if (!numsCount.containsKey(tasks[index])) {
                numsCount.put(tasks[index], 0);
            }
            numsCount.compute(tasks[index], (k, v) ->
                    v + 1
            );
        }
        int tasksCount = 0;
        for (var key : numsCount.keySet()) {
            numsCount.get(key);
            int count2 = numsCount.get(key) % 2;


        }
        return tasksCount;
    }


}
