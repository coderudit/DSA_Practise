package com.dsa.app.final450.Arrays;

import java.util.*;

public class _32_B_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        _32_B_IntersectionOfTwoArrays obj = new _32_B_IntersectionOfTwoArrays();
        obj.intersection(nums1, nums2);
    }

    public int intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int index = 0; index < nums1.length; index++) {
            nums1Set.add(nums1[index]);
        }

        int count = 0;
        for (int index = 0; index < nums2.length; index++) {
            if (nums1Set.contains(nums2[index])) {
                count++;
                nums1Set.remove(nums1[index]);
            }
        }

        return count;
    }
}
