package com.dsa.app.level1.gettingstarted;

public class _9_primefactorization {
    public static void main(String[] args) {
        _9_primefactorization pf = new _9_primefactorization();
        pf.basicPF(46);

    }

    private void basicPF(int number) {

        for (int div = 2; div * div <= number; div++) {
            while (number % div == 0) {
                number /= div;
                System.out.println(div);
            }
        }

        if(number!=1)
            System.out.println(number);
    }
}
