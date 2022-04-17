package com.dsa.app.final450.Strings;

public class _7_CountAndSayProblem {
    public static void main(String[] args) {
        _7_CountAndSayProblem obj = new _7_CountAndSayProblem();
        System.out.println(obj.countAndSay(5));
    }

    private String countAndSay(int n) {
        if (n == 1)
            return "1";

        if (n == 2)
            return "11";
        String result = countAndSay(n - 1);
        StringBuilder temp = new StringBuilder();
        int count = 1;
        for (int index = 1; index <= result.length(); index++) {
            if (index == result.length() || result.charAt(index) != result.charAt(index - 1)) {
                temp.append(count).append(result.charAt(index - 1));
                count = 1;
            } else {
                count++;
            }
        }
        return temp.toString();
    }
}
