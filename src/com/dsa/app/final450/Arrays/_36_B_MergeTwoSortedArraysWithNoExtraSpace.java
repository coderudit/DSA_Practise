package com.dsa.app.final450.Arrays;

public class _36_B_MergeTwoSortedArraysWithNoExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = {10};
        int[] arr2 = {2, 3};
        int[] arr3 = {10, 12};
        int[] arr4 = {5, 18, 20};
        _36_B_MergeTwoSortedArraysWithNoExtraSpace obj = new _36_B_MergeTwoSortedArraysWithNoExtraSpace();
        obj.mergeUsingInsertionSort(arr3, arr4);
        for (int index = 0; index < arr3.length; index++) {
            System.out.println(arr3[index]);
        }
        System.out.println();
        for (int index = 0; index < arr4.length; index++) {
            System.out.println(arr4[index]);
        }
    }

    private void mergeUsingInsertionSort(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] > arr2[index2]) {
                int temp = arr2[index2];
                arr2[index2] = arr1[index1];
                arr1[index1] = temp;

                int currentIndex = index2;
                while (currentIndex < arr2.length && arr2[currentIndex] > arr2[currentIndex + 1]) {
                    int temp2 = arr2[currentIndex];
                    arr2[currentIndex] = arr2[currentIndex + 1];
                    arr2[currentIndex + 1] = temp2;
                }
            }
            index1++;
        }

    }

    private void gapMethod(int[] arr1, int[] arr2) {
    }

}
