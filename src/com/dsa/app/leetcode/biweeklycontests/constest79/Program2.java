package com.dsa.app.leetcode.biweeklycontests.constest79;

import java.util.Arrays;
import java.util.TreeMap;

public class Program2 {
    public static void main(String[] args) {
        Program2 problem = new Program2();
        String[] messages = {"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"};
        String[] messages2 = {"How is leetcode for everyone", "Leetcode is useful for practice"};
        String[] senders = {"Alice", "userTwo", "userThree", "Alice"};
        String[] senders2 = {"Bob", "Charlie"};
        problem.largestWordCount(messages2, senders2);
    }

    public String largestWordCount(String[] messages, String[] senders) {
        TreeMap<String, Integer> messagesMap = new TreeMap<>();
        for (int index = 0; index < messages.length; index++) {
            if (!messagesMap.containsKey(senders[index])) {
                messagesMap.put(senders[index], 0);
            }
            int messageSize = ((messages[index]).split(" ")).length;
            messagesMap.put(senders[index], messagesMap.get(senders[index]) + messageSize);
        }

        int overallMax = -1;
        String value = "";
        for (var key : messagesMap.keySet()) {
            if (messagesMap.get(key) > overallMax) {
                overallMax = messagesMap.get(key);
                value = key;
            } else if (messagesMap.get(key) == overallMax) {
                    value = checkAlphabets(key, value);
            }
        }
        return value;
    }

    private String checkAlphabets(String str1, String str2) {
        int str1Index = 0;
        int str2Index = 0;
        while (str1Index < str1.length() && str2Index < str2.length()) {
            if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
                str1Index++;
                str2Index++;
                continue;
            } else if (str1.charAt(str1Index) < str2.charAt(str2Index))
                return str2;
            else
                return str1;

        }
        return str1;
    }
}
