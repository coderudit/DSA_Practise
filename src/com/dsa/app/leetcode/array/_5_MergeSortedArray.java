package com.dsa.app.leetcode.array;

public class _5_MergeSortedArray {



    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = m+n-1;
        m--;
        n--;

        while(n >= 0){
            if(m>=0 && nums1[m]>nums2[n])
                nums1[position--]=nums1[m--];
            else
                nums1[position--]=nums2[n--];
        }
    }

}


