package com.dsa.app.final450.Arrays;

public class _5_SortArrayWith012 {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 1, 1, 2, 0, 0, 0, 1, 1, 2, 2, 0, 1, 2, 0};
        _5_SortArrayWith012 obj = new _5_SortArrayWith012();
        obj.sort012(arr, arr.length);
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }

    private void sort012(int a[], int n) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;
        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(low, mid, a);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(mid, high, a);
                    high--;
                    break;
            }
        }
    }

    private void swap(int start, int end, int[] a) {
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
