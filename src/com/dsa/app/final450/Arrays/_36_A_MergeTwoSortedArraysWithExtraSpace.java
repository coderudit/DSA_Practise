package com.dsa.app.final450.Arrays;

public class _36_A_MergeTwoSortedArraysWithExtraSpace {
    public static void main(String[] args) {
        _36_A_MergeTwoSortedArraysWithExtraSpace obj = new _36_A_MergeTwoSortedArraysWithExtraSpace();
        int[] arr1 = {2, 5, 12, 18, 20};
        int[] arr2 = {7, 9, 11, 15, 25, 25, 28, 30, 35};
        int[] mergedArray = obj.merge(arr1, arr2);
        for (int index = 0; index < mergedArray.length; index++) {
            System.out.println(mergedArray[index]);
        }
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];
        int mergeIndex = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                mergedArray[mergeIndex++] = arr1[index1++];
            } else if (arr1[index1] > arr2[index2]) {
                mergedArray[mergeIndex++] = arr2[index2++];
            } else {
                index1++;
                mergedArray[mergeIndex++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length)
            mergedArray[mergeIndex++] = arr1[index1++];
        while (index2 < arr2.length)
            mergedArray[mergeIndex++] = arr2[index2++];
        return mergedArray;
    }
}
