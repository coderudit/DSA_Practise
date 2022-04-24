package com.dsa.app.level2.dynamicprogramming;

public class _7_2KeysKeyboard {
    public static void main(String[] args) {
        _7_2KeysKeyboard program = new _7_2KeysKeyboard();
        program.minSteps(1048);
    }

    /*
     * Time Complexity: O(sqrt{N}).
     * When N is the square of a prime, our loop does O(sqrt{N}) steps.
     * Space Complexity: O(1)O(1), the space used by ans and d.
     * */
    private int minSteps(int n) {
        int ans = 0;
        int primeNumber = 2;
        while (n > 1) {
            while (n % primeNumber == 0) {
                ans += primeNumber;
                n /= primeNumber;
                System.out.println(primeNumber);
            }
            primeNumber++;
        }
        return ans;
    }
}
