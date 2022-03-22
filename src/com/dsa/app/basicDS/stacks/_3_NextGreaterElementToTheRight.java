package com.dsa.app.basicDS.stacks;

import java.util.Stack;

public class _3_NextGreaterElementToTheRight {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int[] newArr = solve(arr);
        for (int index = 0; index < newArr.length; index++) {
            System.out.println(newArr[index]);
        }

    }

    public static int[] solve(int[] arr) {
        int[] newArr = new int[arr.length];
        //newArr[arr.length-1] = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int index = arr.length - 1; index >= 0; index--) {
            while (stack.size() > 0 && stack.peek() <= arr[index]) {
                stack.pop();
            }
            if (stack.isEmpty())
                newArr[index] = -1;
            else
                newArr[index] = stack.peek();

            stack.push(arr[index]);
        }
        return newArr;
    }

}
