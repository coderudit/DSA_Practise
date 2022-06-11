package com.dsa.app.interviewpatterns._4_heap;

import java.util.PriorityQueue;

public class _1_kthLargestElement {
    public static void main(String[] args) {
        _1_kthLargestElement problem = new _1_kthLargestElement();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        problem.findKthLargest(nums, k);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int index = 0; index < nums.length; index++){
            if(k!=0){
                pq.add(nums[index]);
                k--;
            }else{
                if(pq.peek() < nums[index]){
                    pq.remove();
                    pq.add(nums[index]);
                }
            }

        }
        return pq.peek();
    }

    /* 38 % faster*/
    /*private int prSolution(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (var element : nums) {
            pq.add(element);
        }

        k = nums.length-k;
        while (k > 0) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }*/

    /* 5 % faster*/
    /*private int arrSortSolution(int[] nums, int k){
        Arrays.sort(nums);
         for (var element : nums) {
            System.out.println(element);
        }
        return nums[nums.length-k];
    }*/

    private int[] heap;
    private int currentIndex = 0;



    private void insertInHeap(int element) {
        if (heap.length == 0) {
            currentIndex++;
            heap[currentIndex] = element;
            return;
        }

        currentIndex++;
        heap[currentIndex] = element;
        heapify();
    }

    private void heapify() {
        int currentParent = currentIndex / 2;
        int child = currentIndex;
        while (child > 1) {
            if (heap[child] > heap[currentParent]) {
                int temp = heap[currentParent];
                heap[currentParent] = heap[child];
                heap[child] = temp;
                child = currentParent;
                currentParent = currentParent / 2;
            } else {
                return;
            }
        }
    }
}
