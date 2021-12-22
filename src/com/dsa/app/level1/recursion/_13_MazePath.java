package com.dsa.app.level1.recursion;

import java.util.ArrayList;
import java.util.List;

public class _13_MazePath {
    public static void main(String[] args) {
        /*for (var item : getMazePaths(1, 1, 3, 3)) {
            System.out.println(item);
        }*/

        for (var item : getMazePathsWithJumps(1, 1, 2, 2)) {
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

    private static List<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            var finalPaths = new ArrayList<String>();
            finalPaths.add("");
            return finalPaths;
        }

        List<String> hPaths;
        List<String> vPaths;
        List<String> dPaths;

        List<String> combinedList = new ArrayList<>();

        if (sc != dc) {
            for (int index = 1; index < dc; index++) {
                if (sc + index <= dc) {
                    hPaths = getMazePathsWithJumps(sr, sc + index, dr, dc);
                    for(var item: hPaths){
                        combinedList.add("h"+ index+item);
                    }
                }else
                    break;
            }
        }
        if (sr != dr) {
            for (int index = 1; index < dr; index++) {
                if (sr + index <= dc) {
                    vPaths = getMazePathsWithJumps(sr + index, sc, dr, dc);
                    for(var item: vPaths){
                        combinedList.add("v"+ index+item);
                    }
                }
                else
                    break;
            }
        }
        if (sc != dc && sr != dr) {
            for (int index = 1; index < dr; index++) {
                if (sr + index <= dr) {
                    dPaths = getMazePathsWithJumps(sr + index, sc + index, dr, dc);
                    for(var item: dPaths){
                        combinedList.add("d"+ index+item);
                    }
                }
                else
                    break;
            }

        }

        return combinedList;
    }
}
