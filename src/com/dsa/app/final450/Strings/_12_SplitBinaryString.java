package com.dsa.app.final450.Strings;

public class _12_SplitBinaryString {
    public static void main(String[] args) {
        _12_SplitBinaryString obj = new _12_SplitBinaryString();
        System.out.println(obj.splitString("0100110101"));
    }

    private int splitString(String str) {
        int count0 = 0;
        int count1 = 0;
        int countOfBinary=0;
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == '0') {
                count0++;
            } else if(str.charAt(index) == '1') {
                count1++;
            }
            if (count0 == count1) {
                countOfBinary++;
            }
        }
        return countOfBinary;
    }
}
