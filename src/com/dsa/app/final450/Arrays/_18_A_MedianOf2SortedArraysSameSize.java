package com.dsa.app.final450.Arrays;

public class _18_A_MedianOf2SortedArraysSameSize {
    public static void main(String[] args) {
        _18_A_MedianOf2SortedArraysSameSize obj = new _18_A_MedianOf2SortedArraysSameSize();
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};
        obj.findMedian(arr1, arr2);
    }

    private void findMedian(int[] arr1, int[] arr2) {
        System.out.println(findMedianRec(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1));
    }

    private int findMedianRec(int[] arr1, int start1, int last1, int[] arr2, int start2, int last2) {
        if (last1 - start1 == 1 && last2 - start2 == 1) {
            return (Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[last1], arr2[last2])) / 2;
        }
        int m1 = median(arr1, start1, last1);
        int m2 = median(arr2, start2, last2);

        if (m1 == m2)
            return m1;

        if (m1 < m2) {
            return findMedianRec(arr1, (last1 + start1 + 1) / 2, last1, arr2, start2, (last2 + start2 + 1) / 2);
        } else {
            return findMedianRec(arr1, start1, (last1 + start1 + 1) / 2, arr2, (last2 + start2 + 1) / 2, last2);
        }
    }

    private int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 1)
            return arr[start + (n / 2)];
        else
            return arr[start + (n / 2 - 1)] + arr[start + (n / 2)];
    }
}
