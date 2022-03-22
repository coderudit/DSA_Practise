package com.dsa.app.competitive.part1.biginteger;

import java.math.BigInteger;

public class _1_FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorial(20));
    }

    static BigInteger factorial(int N) {
        BigInteger biginteger = new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            biginteger = biginteger.multiply(BigInteger.valueOf(i));
        }
        return biginteger;
    }
}
