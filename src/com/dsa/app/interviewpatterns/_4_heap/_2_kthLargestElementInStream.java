package com.dsa.app.interviewpatterns._4_heap;

import java.util.PriorityQueue;

public class _2_kthLargestElementInStream {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    int currentK = 0;

    public static void main(String[] args) {
        int[] nums = {};
        int k = 1;
        _2_kthLargestElementInStream problem = new _2_kthLargestElementInStream(k, nums);

        System.out.println(problem.add(3));
        System.out.println(problem.add(5));
        System.out.println(problem.add(10));
        System.out.println(problem.add(9));
        System.out.println(problem.add(4));
    }
    public _2_kthLargestElementInStream(int k, int[] nums) {
        for(int index = 0; index < nums.length; index++){
            if(k== 0){
                if(pq.peek() < nums[index]){
                    pq.remove();
                    pq.add(nums[index]);
                }
            }
            else{
                pq.add(nums[index]);
                k--;
            }
        }
        currentK = k;
    }

    public int add(int val) {
        while(currentK!=0){
            pq.add(val);
            currentK--;
        }

        if(pq.size() == 0)
            return -1;

        if(pq.peek() < val){
            pq.remove();
            pq.add(val);
        }

        return pq.peek();
    }
}
