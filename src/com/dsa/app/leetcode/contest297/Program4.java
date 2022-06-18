package com.dsa.app.leetcode.contest297;

import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Program4 problem = new Program4();
        String[] ideas = {"coffee","donuts","time","toffee"};//{"aaa", "baa", "caa", "bbb", "cbb", "dbb"};
        System.out.println(problem.distinctNames(ideas));
    }

    public long distinctNames(String[] ideas) {
        if (ideas.length == 0)
            return 0;

        Map<Character, ArrayList<String>> adjacencyList = new HashMap<>();
        Set<String> uniqueStrings = new HashSet<>();
        for (int index = 0; index < ideas.length; index++) {
            if (ideas[index] == "")
                continue;

            char ch = ideas[index].charAt(0);
            if (!adjacencyList.containsKey(ch)) {
                adjacencyList.put(ch, new ArrayList<>());
            }
            adjacencyList.get(ch).add(ideas[index]);
            uniqueStrings.add(ideas[index]);
        }

        var keys = adjacencyList.keySet();
        var keysList = keys.stream().toList();

        Set<String> uniqueStringsCovered = new HashSet<>();

        for(int outerIndex = 0; outerIndex < ideas.length; outerIndex++) {

            for(int innerIndex = 0; innerIndex < ideas.length; innerIndex++) {
                String outerStr = ideas[outerIndex];
                String innerStr = ideas[innerIndex];
                String outerStrNew =  innerStr.charAt(0) + outerStr.substring(1);

                String innerStrNew =  outerStr.charAt(0) + innerStr.substring(1);
                if(!uniqueStrings.contains(outerStrNew) && !uniqueStrings.contains(innerStrNew)){
                    uniqueStringsCovered.add(outerStrNew + " "+ innerStrNew);
                }
            }
        }

        /*for (var outerKey : keys) {
            var outerList = adjacencyList.get(outerKey);
            for (int index = 0; index < outerList.size(); index++) {

                for (var innerKey : keys) {
                    var innerList = adjacencyList.get(innerKey);
                    for (int innerIndex = 0; innerIndex < innerList.size(); innerIndex++) {
                        String outerStr = outerList.get(index);
                        String outerStrNew =  innerKey + outerStr.substring(1);
                        String innerStr = innerList.get(innerIndex);
                        String innerStrNew =  outerKey + innerStr.substring(1);
                        if(!uniqueStrings.contains(outerStrNew) && !uniqueStrings.contains(innerStrNew)){
                            uniqueStringsCovered.add(outerStrNew + " "+ innerStrNew);
                        }
                    }
                }
            }

        }*/
        return uniqueStringsCovered.size();
    }
}
