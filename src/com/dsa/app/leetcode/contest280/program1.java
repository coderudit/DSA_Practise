package com.dsa.app.leetcode.contest280;

public class program1 {
    public static void main(String[] args) {
        program1 obj = new program1();
        System.out.println(obj.countOperations(0, 0));
    }

    public int countOperations(int num1, int num2) {
        return makeItZero(num1, num2, 0);
    }

    private static int makeItZero(int num1, int num2, int turn){
        if(num1 == 0|| num2 == 0)
            return turn;

        if(num1 >= num2){
            return makeItZero(num1 - num2, num2, turn+1);
        }else{
            return makeItZero(num1, num2-num1, turn+1);
        }
    }

}
