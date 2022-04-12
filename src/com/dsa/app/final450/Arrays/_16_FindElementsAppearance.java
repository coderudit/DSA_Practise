package com.dsa.app.final450.Arrays;

import java.util.HashMap;
import java.util.Map;

public class _16_FindElementsAppearance {
    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 2, 2, 3, 5, 4,
                2, 2, 3, 1, 1, 1};
        int n = 12;
        int k = 4;
        _16_FindElementsAppearance obj = new _16_FindElementsAppearance();
        obj.morethanNdK(a, n, k);
    }

    private void morethanNdK(int a[], int n, int k) {
        Map<Integer, Integer> numsMap = new HashMap();
        for (int index = 0; index < a.length; index++) {
            if (!numsMap.containsKey(a[index])) {
                numsMap.put(a[index], 0);
            }
            numsMap.put(a[index], numsMap.get(a[index]) + 1);
        }

        for (var key : numsMap.keySet()) {
            if (numsMap.get(key) > n / k) {
                System.out.println(key);
            }
        }
    }

    private void boyerAndMoore(int a[], int n, int k) {

        int count = 0;
        int result = 0;
        for (int index = 0; index < a.length; index++) {
            if (count == 0) {
                result = a[index];
            } else if (a[index] != result) {
                count--;
            }
        }
    }
}
