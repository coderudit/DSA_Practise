package com.dsa.app.level1.recursion;

import java.util.ArrayList;
import java.util.List;

public class _10_Subsequence {
    public static void main(String[] args) {
        /*var arr = getSubsequence("abc", 0);
        for (int index = 0; index < arr.size(); index++) {
            System.out.println(arr.get(index));
        }*/

        printSS("abc", 0, "");
    }

    private static List<String> getSubsequence(String str, int index) {
        if (index == str.length()) {
            var arr = new ArrayList<String>();
            arr.add("");
            return arr;
        }

        var newArr = new ArrayList<String>();
        newArr.add("");
        newArr.add(String.valueOf(str.charAt(index)));

        var resultArr = getSubsequence(str, index + 1);

        var finalArr = new ArrayList<String>();
        for (var item : resultArr) {
            finalArr.add(newArr.get(0) + item);
        }
        for (var item : resultArr) {
            finalArr.add(newArr.get(1) + item);
        }
        return finalArr;
    }

    public static void printSS(String str, int index, String ans) {
    if(index == str.length()) {
        System.out.println(ans);
        return;
    }
        printSS(str, index + 1, ans+"");
        printSS(str, index + 1, ans + str.charAt(index));
    }


}
