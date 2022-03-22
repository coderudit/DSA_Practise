package com.dsa.app.leetcode.contest283;

import java.util.ArrayList;
import java.util.List;

public class Program1 {
    public static void main(String[] args) {
        var lst = cellsInRange("A1:F1");
        lst.forEach(x-> System.out.println(x));
    }

    public static List<String> cellsInRange(String s) {
        String[] fields = s.split(":");
        Character startingRow = fields[0].charAt(0);
        Character endingRow = fields[1].charAt(0);

        Character startingColumn = fields[0].charAt(1);
        Character endingColumn = fields[1].charAt(1);

        List<String> returnList = new ArrayList<String>();
        for(var row= startingRow; row <= endingRow; row++){
            for(var column = startingColumn; column <= endingColumn; column++){
                returnList.add(String.valueOf((char)row) + column);
            }
        }
        return returnList;
    }
}
