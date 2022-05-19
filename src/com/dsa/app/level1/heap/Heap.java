package com.dsa.app.level1.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private int size;
    List<Integer> heapList;

    public Heap() {
        heapList = new ArrayList<>();
        heapList.add(-1); //Heap will store elements after 0th index.
        size = 0;
    }

    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(12);
        maxHeap.insert(6);
        maxHeap.insert(40);
    }

    private void insert(int value) {
        heapList.add(value);
        if (heapList.size() == 2) {
            return;
        }

        int currentIndex = heapList.size() - 1;
        int parentIndex = currentIndex / 2;
        while (parentIndex > 0 && heapList.get(parentIndex) < heapList.get(currentIndex)) {
            int temp = heapList.get(parentIndex);
            heapList.set(parentIndex, heapList.get(currentIndex));
            heapList.set(currentIndex, temp);
            currentIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }
}
