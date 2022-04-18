package com.dsa.app.final450.Strings;

public class _10_PrintAllSubsequences {
    public static void main(String[] args) {
        _10_PrintAllSubsequences program = new _10_PrintAllSubsequences();
        program.printSubsequence("abc", "", 0);
    }
    private void printSubsequence(String str, String answer, int index){
        if(index == str.length()){
            System.out.println(answer);
            return;
        }

        printSubsequence(str, answer + str.charAt(index), index+1);
        printSubsequence(str, answer, index+1);
    }
}
