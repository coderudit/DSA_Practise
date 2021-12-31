package com.dsa.app.level1.recursion;

import java.util.Scanner;

public class _4_PowerLogarithmic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = 1.00000;
        int power = -2147483648;
        double result = myPow(number, power);
        System.out.println(result);
    }

    public static double myPow(double x, int n) {
        if(n==0)
            return 1;
        else if(n==1)
            return x;
        else if(x == 1){
            return x;
        }
        int newN = n;
        if(newN < 1){
            newN = Math.abs(newN);
        }
        double result =  logarithmicPower(x, newN);
        if(n < 1){
            result = 1/result;
        }
        return result;
    }

    private static double logarithmicPower(double number, int power) {
        if (power == 1) {
            return number;
        }
        double result = logarithmicPower(number, (int) power / 2);
        result = result * result;
        if (power % 2 != 0)
            result = result * number;
        return result;
    }
}
