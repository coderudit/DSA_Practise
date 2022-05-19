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

        System.out.println(maxHeap.delete());
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

    private int delete() {
        if (heapList.size() <= 1)
            return -1;

        //Takes the top value from the heap.
        int temp = heapList.get(1);

        //Store last element as the top of the heap.
        heapList.set(1, heapList.get(heapList.size() - 1));

        //Delete the last element from the heap.
        heapList.remove(heapList.size() - 1);

        int parentIndex = 1;
        int currentIndex = 0;

        while (parentIndex * 2 + 1 < heapList.size() || heapList.get(parentIndex) < heapList.get(currentIndex)) {
            currentIndex = heapList.get(parentIndex * 2) > heapList.get(parentIndex * 2 + 1) ? parentIndex * 2 : parentIndex * 2 + 1;
            int current = heapList.get(parentIndex);
            heapList.set(parentIndex, heapList.get(currentIndex));
            heapList.set(currentIndex, current);
            parentIndex = currentIndex;
        }
        return temp;
    }
}
