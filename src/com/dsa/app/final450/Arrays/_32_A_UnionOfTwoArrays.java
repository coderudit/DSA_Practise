package com.dsa.app.final450.Arrays;

import java.util.HashSet;
import java.util.Set;

public class _32_A_UnionOfTwoArrays {
    public static void main(String[] args) {


    }

    private int union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr1)
            set.add(val);
        for (int val : arr2)
            set.add(val);
        return set.size();
    }
}
