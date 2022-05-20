package com.dsa.app.level1.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1_KthSmallestElement {
    public static void main(String[] args) {
        _1_KthSmallestElement program = new _1_KthSmallestElement();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 4;
        System.out.println(program.kthSmallestElement(arr, k));
    }

    private int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new HeapComparator());
        for (int index = 0; index < k; index++) {
            pq.add(arr[index]);
        }

        for (int index = k; index < arr.length; index++) {
            if (pq.peek() > arr[index]) {
                pq.poll();
                pq.add(arr[index]);
            }
        }

        return pq.poll();
    }
}

class HeapComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.intValue() - o1.intValue();
    }
}
