package com.dsa.app.level1.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _11_Kpc {

    private static Map<Integer, String> keyPadDict;

    public _11_Kpc() {

    }

    public static void main(String[] args) {
        keyPadDict = new HashMap<>();
        keyPadDict.put(0, ".;");
        keyPadDict.put(1, "abc");
        keyPadDict.put(2, "def");
        keyPadDict.put(3, "ghi");
        keyPadDict.put(4, "jkl");
        keyPadDict.put(5, "mno");
        keyPadDict.put(6, "pqrs");
        keyPadDict.put(7, "tu");
        keyPadDict.put(8, "vwx");
        keyPadDict.put(9, "yz");
        for (var item : printKeypadCombination("573")) {
            System.out.println(item);
        }
    }

    private static List<String> printKeypadCombination(String input) {
        return addKPC(input, 0);
    }

    private static List<String> addKPC(String input, int currentIndex) {
        if (currentIndex == input.length()) {
            var list = new ArrayList<String>();
            list.add("");
            return list;
        }
        String keyPadValue = keyPadDict.get(Integer.parseInt(String.valueOf(input.charAt(currentIndex))));
        String[] splitValue = keyPadValue.split("");
        var keyPadList = new ArrayList<String>();

        for (var item : splitValue) {
            keyPadList.add(item);
        }
        var returnedList = addKPC(input, currentIndex + 1);

        var newList = new ArrayList<String>();
        for (var outerItem : returnedList) {
            for (var inneritem : keyPadList) {
                newList.add(inneritem + outerItem);
            }
        }
        return newList;
    }
}
