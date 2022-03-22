package com.dsa.app.basicDS.stacks;

import java.util.Stack;

public class _4_StockSpan {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 1, 3, 5};
        int[] newArr = solve(arr);
        for(int index = 0; index < newArr.length; index++) {
            System.out.println(newArr[index]);
        }
    }

    public static int[] solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] spanArray = new int[arr.length];
        int spanCount = 0;
        for (int index = 0; index < arr.length; index++) {
            if(stack.isEmpty()){
                spanArray[index] = 1;
            }
            else if(stack.peek() <= arr[index]){
                while(stack.isEmpty() || stack.peek() > arr[index]){
                    stack.pop();
                    spanCount++;
                }
                spanArray[index] = spanCount;
            }
            stack.push(arr[index]);
            spanCount = 1;
        }
        return spanArray;
    }
}
