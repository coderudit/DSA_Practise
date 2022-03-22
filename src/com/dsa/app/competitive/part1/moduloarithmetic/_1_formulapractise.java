package com.dsa.app.competitive.part1.moduloarithmetic;

public class _1_formulapractise {
    public static void main(String[] args) {

        int x = 7;
        int y = 8;
        int fact_x = factorial(x) % 13;
        int fact_y = factorial(y) % 13;

        System.out.println(fact_x);
        System.out.println(fact_y);

        int final_value = (fact_x + fact_y) % 15;
        System.out.println(final_value);
    }

    public static int factorial(int num) {
        int sum = 1;
        for (int index = 2; index <= num; index++) {
            sum *= index;
        }
        return sum;
    }
}
