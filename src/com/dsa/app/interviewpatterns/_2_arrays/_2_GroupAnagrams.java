package com.dsa.app.interviewpatterns._2_arrays;

import java.util.*;

public class _2_GroupAnagrams {
    public static void main(String[] args) {

    }

    //O N * KLogK
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();

        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    //O N K.. but this does not perform faster
    public List<List<String>> groupAnagramsOptimized(String[] strs){
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];

        for(String s: strs){
            Arrays.fill(count, 0);

            for(char c: s.toCharArray()) count[c-'a']++;

            StringBuilder sb = new StringBuilder();
            for(int index=0; index< 26; index++){
                sb.append("#");
                sb.append(count[index]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
