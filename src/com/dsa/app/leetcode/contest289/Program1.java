package com.dsa.app.leetcode.contest289;

public class Program1 {
    public static void main(String[] args) {
        Program1 obj = new Program1();
        String str1 = "11111222223";
        String str2 = "00000000";
        String str3 = "0";
        String str4 = "233";
        String str5 = "01234567890";
        String str6 = "475730385258137";
        System.out.println(obj.digitSum(str6, 13));
    }


    public String digitSum(String s, int k) {
        return divideAndConquer(s, k);
    }

    private String divideAndConquer(String s, int k) {
        if (k >= s.length())
            return s;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < s.length(); index += k) {
            if (index + k < s.length())
                sb.append(calculateValue(s.substring(index, index + k)));
            else
                sb.append(calculateValue(s.substring(index)));
        }
        if (sb.length() > k)
            return divideAndConquer(sb.toString(), k);
        return sb.toString();
    }

    private String calculateValue(String str) {
        int sum = 0;
        for (int index = 0; index < str.length(); index++) {
            sum += (str.charAt(index) - 48);
        }
        return String.valueOf(sum);
    }


}
