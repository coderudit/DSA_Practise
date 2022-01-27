package com.dsa.app.level1.gettingstarted;

public class _8_gcdandlcm {
    public static void main(String[] args) {
        _8_gcdandlcm obj = new _8_gcdandlcm();
        System.out.println("GCD :" + obj.findGcd(36, 24));
        System.out.println("LCM : " + obj.findLcm(36, 24));
    }

    private int findGcd(int number1, int number2){
        int divisor = Math.min(number1, number2);
        int dividend = Math.max(number1, number2);
        while(divisor != 0){
            int remainder = dividend % divisor;
            if(remainder == 0)
                return divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return -1;
    }

    private int findLcm(int number1, int number2){
        int gcd = findGcd(number1, number2);
        return (number1 * number2)/gcd;
    }
}
