package com.dsa.app.level1.recursion;

import java.util.ArrayList;
import java.util.List;

public class _13_MazePath {
    public static void main(String[] args) {
        for (var item : getMazePaths(1, 1, 3, 3)) {
            System.out.println(item);
        }
    }

    private static List<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            var finalPaths = new ArrayList<String>();
            finalPaths.add("");
            return finalPaths;
        }
        List<String> hPaths = new ArrayList<>();
        List<String> vPaths = new ArrayList<>();
        if (sc != dc) {
            hPaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if (sr != dr) {
            vPaths = getMazePaths(sr + 1, sc, dr, dc);
        }
        List<String> combinedList = new ArrayList<>();
        for (var item : hPaths) {
            combinedList.add("h" + item);
        }
        for (var item : vPaths) {
            combinedList.add("v" + item);
        }
        return combinedList;
    }
}
