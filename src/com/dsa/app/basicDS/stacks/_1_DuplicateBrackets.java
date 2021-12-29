package com.dsa.app.basicDS.stacks;

import java.util.Stack;

public class _1_DuplicateBrackets {
    public static void main(String[] args) {
        boolean result1 = ifDuplicateBrackets("((a+b)+(c+d))");
        boolean result2 = ifDuplicateBrackets("(a+b)+((c+d))");
        System.out.println();
    }

    public static boolean ifDuplicateBrackets(String input) {
        Stack<Character> inputStack = new Stack<Character>();
        for(int index = 0; index < input.length(); index++){
            if(input.charAt(index) == ')')
            {
                if(inputStack.peek() == '(')
                    return true;
                while(inputStack.peek() != '('){
                    inputStack.pop();
                }
                inputStack.pop();
            }
            else
                inputStack.push(input.charAt(index));
        }

        return false;
    }

}
