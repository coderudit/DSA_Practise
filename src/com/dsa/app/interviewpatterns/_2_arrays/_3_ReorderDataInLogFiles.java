package com.dsa.app.interviewpatterns._2_arrays;

import java.util.Arrays;

public class _3_ReorderDataInLogFiles {
    public static void main(String[] args) {
        _3_ReorderDataInLogFiles problem = new _3_ReorderDataInLogFiles();
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        problem.reorderLogFiles(logs);
    }

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (log1, log2) -> {

            String[] firstStr = log1.split(" ", 2);
            String[] secondStr = log2.split(" ", 2);

            boolean isFirstDigit = Character.isDigit(firstStr[1].charAt(0));
            boolean isSecondDigit = Character.isDigit(secondStr[1].charAt(0));

            if (!isFirstDigit && !isSecondDigit) {
                int comp = firstStr[1].compareTo(secondStr[1]);
                if (comp == 0) {
                    comp = log1.compareTo(log2);
                }
                return comp;
            }

            //1 means this is greater.
            if (isFirstDigit && !isSecondDigit) {
                return 1;
            } else if (!isFirstDigit && isSecondDigit) {
                return -1;
            } else {
                return 0;
            }

        });
        return logs;
    }
}
