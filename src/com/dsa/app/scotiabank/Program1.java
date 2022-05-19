package com.dsa.app.scotiabank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Program1 {
    private Map<Integer, String> daysMap = new HashMap<>();
    private String[] daysArr = new String[8];

    public static void main(String[] args) {

        Program1 program = new Program1();
        System.out.println(program.solution("Sat", 23));
    }

    private String solution(String S, int K) {
        daysArr[1] = "Mon";
        daysArr[2] = "Tue";
        daysArr[3] = "Wed";
        daysArr[4] = "Thu";
        daysArr[5] = "Fri";
        daysArr[6] = "Sat";
        daysArr[7] = "Sun";

        int currentDay = linearSearch(S);
        K = (K + currentDay) % 7;

         return daysArr[K];
    }

    private int linearSearch(String day) {
        int findIndex = -1;
        for (int index = 1; index < daysArr.length; index++) {
            if (daysArr[index].equals(day))
                return index;
        }
        return findIndex;
    }
}

        /*daysMap.put(1, "Mon");
                daysMap.put(2, "Tue");
                daysMap.put(3, "Wed");
                daysMap.put(4, "Thu");
                daysMap.put(5, "Fri");
                daysMap.put(6, "Sat");
                daysMap.put(7, "Sun");*/
