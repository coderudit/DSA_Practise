package com.dsa.app.leetcode.recursion;

public class _50_Pow {
    public static void main(String[] args) {
        _50_Pow obj = new _50_Pow();
        System.out.println(obj.myPow(2.0, -2));
    }

    public double myPow(double x, int n) {
        if (n == 1)
            return x;
        else if (n == 0)
            return 1;
        else if(n==-1)
            return 1/x;

        double result = myPow(x, n / 2);
            result = result * result;
            if (n % 2 == 1)
                result *= x;
        return result;
    }
}
