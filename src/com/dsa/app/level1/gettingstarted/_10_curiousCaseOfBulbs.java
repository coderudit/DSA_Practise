package com.dsa.app.level1.gettingstarted;

public class _10_curiousCaseOfBulbs {
    public static void main(String[] args) {
        _10_curiousCaseOfBulbs obj = new _10_curiousCaseOfBulbs();
        obj.curiousCase(588355504);
    }

    private void curiousCase(int number) {
        int count =0;
        for (int index = 1; index * index <= number; index = index + 1) {
            System.out.println(index * index);
            count++;
        }
    }
}
