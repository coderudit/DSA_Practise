package com.dsa.app.interviewpatterns._1_twopointers.slidingwindow;

import java.util.*;

public class _4_MaxOfAllSubarrays {
    public static void main(String[] args) {
        _4_MaxOfAllSubarrays problem = new _4_MaxOfAllSubarrays();
        int[] arr = {1, -1};//{1, 3, 1, 2, 0, 5};
        int K = 1;//3
        System.out.println(problem.maxOfAllSubArraysUsingPQ(K, arr).toString());
    }

    public int[] maxOfAllSubArrays(int k, int[] nums) {
        int index = 0;
        int currentMax = Integer.MIN_VALUE;
        int currentMaxIndex = -1;
        int[] maxList = new int[nums.length - k + 1];
        while (index < k) {
            if (currentMax < nums[index]) {
                currentMax = nums[index];
                currentMaxIndex = index;
            }
            index++;
        }
        int maxListIndex = 0;
        maxList[maxListIndex++] = currentMax;
        while (index < nums.length) {
            if (index - k >= currentMaxIndex) {
                if (nums[index - k + 1] > nums[index - k + 2]) {
                    currentMax = nums[index - k + 1];
                    currentMaxIndex = index - k + 1;
                } else {
                    currentMax = nums[index - k + 2];
                    currentMaxIndex = index - k + 2;
                }
            }
            if (currentMax < nums[index]) {
                currentMax = nums[index];
                currentMaxIndex = index;
            }

            maxList[maxListIndex++] = currentMax;
            index++;
        }

        return maxList;
    }

    //Gets TLE as complexity O(nlogK)
    public int[] maxOfAllSubArraysUsingPQ(int k, int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] maxList = new int[nums.length - k + 1];
        int maxListIndex = 0;
        int index = 0;

        while (index < k) {
            pq.add(nums[index]);
            index++;
        }
        maxList[maxListIndex++] = pq.peek();
        while (index < nums.length) {
            pq.remove(nums[index - k]);
            pq.add(nums[index]);
            maxList[maxListIndex++] = pq.peek();
            index++;
        }
        return maxList;
    }

    public int[] maxOfAllSubArraysUsingDeque(int k, int[] nums) {
        ArrayDeque<Integer> pq = new ArrayDeque<>();

        int[] maxList = new int[nums.length - k + 1];
        int maxListIndex = 0;
        int index = 0;

        while(index < k){
            while(!pq.isEmpty() && nums[pq.peekLast()] <= nums[index]){
                pq.removeLast();
            }
            pq.addLast(index);
            index++;
        }

        while(index < nums.length){
            maxList[maxListIndex++] = nums[pq.peekFirst()];

            while(!pq.isEmpty() && pq.peek() <= (index-k)){
                pq.removeFirst();
            }

            while(!pq.isEmpty() && nums[pq.peekLast()] <= nums[index]){
                pq.removeLast();
            }
            pq.addLast(index);
            index++;
        }
        maxList[maxListIndex++] = nums[pq.peekFirst()];
        return maxList;
    }
}
