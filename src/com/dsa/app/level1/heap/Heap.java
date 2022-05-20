package com.dsa.app.level1.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private int size;
    static List<Integer> heapList;

    public Heap() {
        heapList = new ArrayList<>();
        heapList.add(-1); //Heap will store elements after 0th index.
        size = 0;
    }

    public static void main(String[] args) {
        //1. Insert into Heap
        /*Heap maxHeap = new Heap();
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(12);
        maxHeap.insert(6);
        maxHeap.insert(40);*/

        //2. Delete from Heap
        /*int size = heapList.size();
        for (int index = 0; index < size - 1; index++) {
            System.out.println(maxHeap.delete());
        }*/

        Heap maxHeapify = new Heap();
        int[] arr = {54, 53, 55, 52, 50};
        for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
            heapList.add(arr[outerIndex]);
            for (int index = arr.length / 2; index > 0; index--) {
                maxHeapify.heapify(index);
            }
        }
        System.out.println();
    }

    private void insert(int value) {
        heapList.add(value);
        //Return if this is the only inserted element.
        if (heapList.size() == 2) {
            return;
        }

        int childIndex = heapList.size() - 1;
        while (childIndex > 1) {
            int parentIndex = childIndex / 2;

            if (heapList.get(parentIndex) < heapList.get(childIndex)) {
                swap(heapList, parentIndex, childIndex);
                childIndex = parentIndex;

            } else {
                return;
            }
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

        while (parentIndex < heapList.size()) {
            int leftChild = parentIndex * 2;
            int rightChild = leftChild + 1;
            int currentIndex;

            if (!(rightChild < heapList.size())) {
                if (!(leftChild < heapList.size()))
                    break;
                else
                    currentIndex = leftChild;
            } else {
                currentIndex = heapList.get(leftChild) > heapList.get(rightChild) ? leftChild : rightChild;
            }

            if (heapList.get(parentIndex) < heapList.get(currentIndex)) {
                swap(heapList, currentIndex, parentIndex);
                parentIndex = currentIndex;
            } else {
                break;
            }
        }
        return temp;
    }

    //Process nodes from 1 to n/2, as n/2 + 1 to n nodes are leaves and therefore, already in Heap.
    private void heapify(int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        int currentIndex = 0;
        if(!(rightChild < heapList.size())){
            if(!(leftChild < heapList.size())) {
                return;
            }else{
                currentIndex = leftChild;
            }
        }else {
            currentIndex = heapList.get(leftChild) > heapList.get(rightChild) ? leftChild : rightChild;
        }
        if (heapList.get(index) < heapList.get(currentIndex)) {
            swap(heapList, index, currentIndex);
            heapify(currentIndex);
        }
    }

    private void swap(List<Integer> heap, int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }


}
