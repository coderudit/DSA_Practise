package com.dsa.app.leetcode.monthlychallenge.may;

import java.util.Stack;

public class _1_BackspaceCompare {
    public static void main(String[] args) {
        _1_BackspaceCompare program = new _1_BackspaceCompare();
        String s = "abcd";
        String t = "bbcd";
        System.out.println(program.backspaceCompare(s, t));
    }

    /*
    * Time Complexity: O(M + N)O(M+N), where M, NM,N are the lengths of S and T respectively.
    * Space Complexity: O(M + N)O(M+N).
    * */
    private boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1= new Stack<Character>();
        for(int index=0; index< s.length(); index++){
            if(s.charAt(index) == '#'){
                if(stack1.size() > 0){
                    stack1.pop();
                }
            }
            else{stack1.push(s.charAt(index));}
        }

        Stack<Character> stack2= new Stack<Character>();
        for(int index=0; index< t.length(); index++){
            if(t.charAt(index) == '#'){
                if(stack2.size() > 0){
                    stack2.pop();
                }
            }
            else{stack2.push(t.charAt(index));}
        }

        if(stack1.size() != stack2.size()){
            return false;
        }

        while(!stack1.isEmpty()){
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }

        return true;
    }
}
