package com.dsa.app.final450.Strings;

public class _8_LongestPalindromicString {
    public static void main(String[] args) {
        _8_LongestPalindromicString obj = new _8_LongestPalindromicString();
        String str = "abccbc";
        System.out.println(obj.dp_substring(str));
    }

    /*
     * O(n*n*n) where O(n*n) for going through each substring
     * and O(n) for checking if a string is palindrome or not.
     * */
    private void bruteForce_eachSubstring(String str) {

    }

    /*
     * O(n*n)
     * */
    private int dp_substring(String str) {
        boolean[][] table = new boolean[str.length()][str.length()];
        int length = 0;
        for (int gap = 0; gap < str.length(); gap++) {
            //All diagonals start at 0th row and their respective columns,
            //and ends at the last column.
            for (int row = 0, column = gap; column < table.length; row++, column++) {
                if (gap == 0)
                    table[row][column] = true;
                else if (gap == 1) {
                    if (str.charAt(row) == str.charAt(column))
                        table[row][column] = true;
                    else
                        table[row][column] = false;
                } else {
                    if (str.charAt(row) == str.charAt(column) && table[row + 1][column - 1] == true) {
                        table[row][column] = true;
                    } else
                        table[row][column] = false;
                }
                if (table[row][column] == true)
                    length = gap + 1;
            }
        }
        return length;
    }

    private int simple_manacherAlgo(String str){
        return 1;
    }
}
