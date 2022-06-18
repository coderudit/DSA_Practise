package com.dsa.app.leetcode.contest297;

public class Program1 {
    public static void main(String[] args) {
        Program1 problem = new Program1();
        int[][] brackets = {{2,50}};
        int income = 0;
        System.out.println(problem.calculateTax(brackets, income));
    }

    public double calculateTax(int[][] brackets, int income) {
        double totalSum = 0;

        int previousValue = 0;

        for (int index = 0; index < brackets.length; index++) {
            int currentValue = brackets[index][0] - previousValue;
            if (income - currentValue >= 0) {
                income = income - currentValue;
                totalSum += (double) currentValue * brackets[index][1] / 100;
                previousValue = brackets[index][0];
            } else {
                totalSum += (double) income * brackets[index][1] / 100;
                break;
            }
        }
        return totalSum;
    }
}
