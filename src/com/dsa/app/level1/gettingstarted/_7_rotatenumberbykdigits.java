package com.dsa.app.level1.gettingstarted;

public class _7_rotatenumberbykdigits {
    public static void main(String[] args) {
        _7_rotatenumberbykdigits obj = new _7_rotatenumberbykdigits();
        obj.rotateNumber(123456, 2);
    }

    private void rotateNumber(int number, int k) {
        int digits = 0;
        int temp = number;

        while (temp != 0) {
            temp = temp / 10;
            digits++;
        }

        k = k % digits;

        System.out.println(leftRotate(number, k));
    }

    private int leftRotate(int number, int k) {
        StringBuilder strNum = new StringBuilder(String.valueOf(number));

        String firstSub = strNum.substring(0, k);
        String secondSub = strNum.substring(strNum.length() - k, strNum.length());

        strNum.replace(0, k, secondSub);
        strNum.replace(strNum.length() - k, strNum.length(), firstSub);

        return Integer.parseInt(strNum.toString());
    }

    private void rightRotate(int number, int k) {

    }
}
