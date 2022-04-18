package com.dsa.app.final450.Strings;

public class _11_PrintAllPermutations {
    public static void main(String[] args) {
        _11_PrintAllPermutations  program = new _11_PrintAllPermutations();
        program.printPermutations("abc", "");
    }

    private void printPermutations(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int index = 0; index < ques.length(); index++) {
            char ch = ques.charAt(index);
            String qlpart = ques.substring(0, index);
            String qrpart = ques.substring(index + 1);
            String roq = qlpart + qrpart;
            printPermutations(roq, asf + ch);
        }

    }
}
