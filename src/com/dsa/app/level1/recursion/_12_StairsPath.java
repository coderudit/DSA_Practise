package com.dsa.app.level1.recursion;

import java.util.ArrayList;
import java.util.List;

public class _12_StairsPath {
    public static void main(String[] args) {
        for (var item : getStairPaths(3)) {
            System.out.println(item);
        }
    }

    private static List<String> getStairPaths(int n) {
        return addStairPaths(n, 0);
    }

    private static List<String> addStairPaths(int n, int sum) {
        if (n == sum) {
            var list = new ArrayList<String>();
            list.add("");
            return list;
        }
        var newPaths = new ArrayList<String>();

        if (n - sum - 1 >= 0) {
            var returnedPaths = addStairPaths(n, sum + 1);
            for (var item : returnedPaths) {
                newPaths.add(1 + item);
            }
        }


        if (n - sum - 2 >= 0) {
            var returnedPaths = addStairPaths(n, sum + 2);
            for (var item : returnedPaths) {
                newPaths.add(2 + item);
            }
        }

        if (n - sum - 3 >= 0) {
            var returnedPaths = addStairPaths(n, sum + 3);
            for (var item : returnedPaths) {
                newPaths.add(3 + item);
            }
        }

        return newPaths;
    }
}
