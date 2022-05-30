package com.dsa.app.leetcode.biweeklycontests.constest79;

import java.util.*;

public class Program3 {
    private HashMap<Integer, List<Integer>> adjacentRoads = new HashMap<>();

    public static void main(String[] args) {
        Program3 problem = new Program3();
        int n = 6;
        int[][] roads = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};


        int n2 = 4;
        int[][] roads2 = {{3, 2}, {0, 2}};
        System.out.println(problem.maximumImportance(n2, roads2));
    }

    public long maximumImportance(int n, int[][] roads) {
        for (int index = 0; index < roads.length; index++) {
            if (!adjacentRoads.containsKey(roads[index][0])) {
                adjacentRoads.put(roads[index][0], new ArrayList<>());
            }
            adjacentRoads.get(roads[index][0]).add(roads[index][1]);

            if (!adjacentRoads.containsKey(roads[index][1])) {
                adjacentRoads.put(roads[index][1], new ArrayList<>());
            }
            adjacentRoads.get(roads[index][1]).add(roads[index][0]);
        }

        TreeMap<Integer, List<Integer>> priorityQueue = new TreeMap<>();
        for (var key: adjacentRoads.keySet()) {
            if (adjacentRoads.containsKey(key)) {
                int currentSize = adjacentRoads.get(key).size();
                if (!priorityQueue.containsKey(currentSize)) {
                    priorityQueue.put(currentSize, new ArrayList<>());
                }
                priorityQueue.get(currentSize).add(key);
            }
        }

        Map<Integer, Integer> importanceMap = new HashMap<>();
        int importance = n;
        for (int index = priorityQueue.size(); index > 0; index--) {
            for (var item : priorityQueue.pollLastEntry().getValue()) {
                importanceMap.put(item, importance);
                importance--;
            }
        }

        int totalImportance = 0;
        for (int index = 0; index < roads.length; index++) {
            if (importanceMap.containsKey(roads[index][0]) && importanceMap.containsKey(roads[index][1]))
                totalImportance += (importanceMap.get(roads[index][0]) + importanceMap.get(roads[index][1]));
            else if(importanceMap.containsKey(roads[index][0])){
                totalImportance += (importanceMap.get(roads[index][0]));
            }else if(importanceMap.containsKey(roads[index][1])){
                totalImportance += (importanceMap.get(roads[index][1]));
            }
        }
        return totalImportance;
    }

}
