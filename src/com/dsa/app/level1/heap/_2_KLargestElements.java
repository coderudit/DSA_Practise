package com.dsa.app.level1.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _2_KLargestElements {
    public static void main(String[] args) {
        _2_KLargestElements program = new _2_KLargestElements();
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 4;
        var queue = program.kLargestElement(arr, k);
        for(var item: queue){
            System.out.println(item);
        }
    }

    private PriorityQueue<Integer> kLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new HeapComparator());
        for (int index = 0; index < k; index++) {
            pq.add(arr[index]);
        }

        for (int index = k; index < arr.length; index++) {
            if (pq.peek() < arr[index]) {
                pq.poll();
                pq.add(arr[index]);
            }
        }

        return pq;
    }
}

class MinHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.intValue() - o1.intValue();
    }
}


