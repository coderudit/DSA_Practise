package com.dsa.app.level1.heap;

import java.util.PriorityQueue;

public class _4_MinimumCostOfRopes {
    public static void main(String[] args) {
        _4_MinimumCostOfRopes program = new _4_MinimumCostOfRopes();
        long[] arr = {4, 3, 2, 6};
        System.out.println(program.minCost(arr));
    }

    long minCost(long arr[]) {
        // your code here
        PriorityQueue<Long> ropes = new PriorityQueue();

        for (int index = 0; index < arr.length; index++) {
            ropes.add(arr[index]);
        }
        long sum = 0;
        while (ropes.size() > 1) {
            long rope1 = ropes.poll();
            long rope2 = ropes.poll();
            sum += (rope1+rope2);
            ropes.add(rope1+rope2);
        }
        return sum;
    }
}
