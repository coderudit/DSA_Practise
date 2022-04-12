package com.dsa.app.final450.Arrays;

public class _13_FindTheCommonElementsInSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        _13_FindTheCommonElementsInSortedArray obj = new _13_FindTheCommonElementsInSortedArray();
        System.out.println(obj.searchCommonElements(arr1, arr2, arr3));
    }

    private int searchCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int sizeOfAuxiliaryArray = Math.min(Math.min(arr1.length, arr2.length), arr3.length);
        int[] duplicateElements = new int[sizeOfAuxiliaryArray];

        int arr1Index = 0, arr2Index = 0, arr3Index = 0;
        int dupArrIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] == arr2[arr2Index]) {
                duplicateElements[dupArrIndex++] = arr1[arr1Index];
                arr1Index++;
                arr2Index++;
            } else if (arr1[arr1Index] < arr2[arr2Index]) {
                arr1Index++;
            } else if (arr1[arr1Index] > arr2[arr2Index]) {
                arr2Index++;
            }
        }
        int tempDupIndex = dupArrIndex;
        dupArrIndex = 0;
        int count = 0;
        while (dupArrIndex < tempDupIndex && arr3Index < arr3.length) {
            if (duplicateElements[dupArrIndex] == arr3[arr3Index]) {
                count++;
                dupArrIndex++;
                arr3Index++;
            } else if (duplicateElements[dupArrIndex] < arr3[arr3Index]) {
                dupArrIndex++;
            } else if (duplicateElements[dupArrIndex] > arr3[arr3Index]) {
                arr3Index++;
            }
        }
        return count;
    }
}
