package com.dsa.app.level1.dynamicprogramming;

public class _11_UnboundedKnapsack {
    public static void main(String[] args) {
        int[] values = {15, 14, 10, 45, 30};
        int[] weights = {2, 5, 1, 3, 4};
        int bagCapacity = 7;
        _11_UnboundedKnapsack program = new _11_UnboundedKnapsack();
        program.chooseItems(weights, values, bagCapacity);
    }

    private void chooseItems(int[] weights, int[] values, int bagCapacity) {
        int[] dp = new int[bagCapacity + 1];
        dp[0] = 0;
        for (int bagCapacityIndex = 1; bagCapacityIndex <= bagCapacity; bagCapacityIndex++) {
            int maxValue = 0;
            for (int itemIndex = 0; itemIndex < weights.length; itemIndex++) {

                if (bagCapacityIndex >= weights[itemIndex]) {
                    int remainBagCapacity = bagCapacityIndex - weights[itemIndex];
                    int remainBagValue = dp[remainBagCapacity];
                    int totalBagValue = remainBagValue + values[itemIndex];
                    maxValue = Math.max(maxValue, totalBagValue);
                }
                dp[bagCapacityIndex] = maxValue;
            }

        }
        for (int bagCapacityIndex = 1; bagCapacityIndex <= bagCapacity; bagCapacityIndex++) {
            System.out.println(dp[bagCapacityIndex]);
        }

    }
}
