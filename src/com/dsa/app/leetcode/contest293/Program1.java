package com.dsa.app.leetcode.contest293;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program1 {
    public static void main(String[] args) {
        Program1 removeAnagrams = new Program1();
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        String[] words2 = {"a","b","a"};
        var list = removeAnagrams.removeAnagrams(words2);
        for (var item : list) {
            System.out.println(item);
        }
    }

    public List<String> removeAnagrams(String[] words) {
        int wordsCount = 0;
        int wordsLength = words.length;
        List<Integer> uniqueIndex = new ArrayList<>();
        List<String> finalWords = new ArrayList<>();

        for (var word : words) {
            finalWords.add(word);
        }
        while (wordsCount < finalWords.size()) {
            uniqueIndex.add(wordsCount);
            String word = finalWords.get(wordsCount);
            Map<Character, Integer> wordMap = new HashMap<>();

            for (int index = 0; index < word.length(); index++) {
                if (!wordMap.containsKey(word.charAt(index))) {
                    wordMap.put(word.charAt(index), 0);
                }
                wordMap.put(word.charAt(index), wordMap.get(word.charAt(index)) + 1);
            }

            int currentWord = wordsCount + 1;
            while (currentWord < finalWords.size()) {
                String tempWord = finalWords.get(currentWord);
                Map<Character, Integer> tempWordMap = new HashMap<>();
                for (int index = 0; index < tempWord.length(); index++) {
                    if (!tempWordMap.containsKey(tempWord.charAt(index))) {
                        tempWordMap.put(tempWord.charAt(index), 0);
                    }
                    tempWordMap.put(tempWord.charAt(index), tempWordMap.get(tempWord.charAt(index)) + 1);
                }

                if (AreMapSimilar(wordMap, tempWordMap)) {
                    finalWords.remove(tempWord);

                } else {
                    break;
                }


            }
            wordsCount++;
        }

        return finalWords;
    }

    private boolean AreMapSimilar(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.keySet().size() != map2.keySet().size())
            return false;

        for (var item1 : map1.keySet()) {
            if (!map2.containsKey(item1) || (map2.get(item1) != map1.get(item1))) {
                return false;
            }
        }

        return true;
    }
}
