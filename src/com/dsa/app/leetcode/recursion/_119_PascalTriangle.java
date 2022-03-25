package com.dsa.app.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _119_PascalTriangle {


    public static void main(String[] args) {
        new _119_PascalTriangle().getRow(5);
        System.out.println();
    }

    public List<Integer> getRow(int rowIndex) {
        var lst = new ArrayList<Integer>();
        int[][] pascalDP = new int[rowIndex+1][rowIndex+1];
        for(int col = 0; col <= rowIndex; col++){
            lst.add(getPascalList(rowIndex, col, pascalDP));
        }
        lst.forEach(x->System.out.println(x));
        return lst;
    }

    private int getPascalList(int rowIndex, int colIndex, int[][] pascalDP) {
        if (colIndex == 0 || rowIndex == colIndex) {
            return 1;
        }
        if (pascalDP[rowIndex][colIndex] > 0)
            return pascalDP[rowIndex][colIndex];
        int leftCol = getPascalList(rowIndex - 1, colIndex - 1, pascalDP);
        int rightCol = getPascalList(rowIndex - 1, colIndex, pascalDP);
        pascalDP[rowIndex][colIndex] = leftCol + rightCol;
        return pascalDP[rowIndex][colIndex];
    }

    /*private static List<Integer> getRow(int rowIndex) {

        List<PascalPair> resultArr = new ArrayList<>();
        var lstInteger = new ArrayList<Integer>();
        for (int index = 0; index <= rowIndex; index++) {
            lstInteger.add(getValue(rowIndex, index, resultArr));
        }
        return lstInteger;
    }

    private static int getValue(int rowIndex, int colIndex, List<PascalPair> resultArr) {
        if (rowIndex == 0 && colIndex == 0)
            return 1;
        else if (colIndex < 0)
            return 0;
        else if (rowIndex < 0)
            return 0;
        else if(colIndex > Math.floor((rowIndex)/2)){
            int newColIndex= (int) Math.floor((rowIndex)/2);
            var pasPairNew = new PascalPair(rowIndex,  colIndex - newColIndex+1);
            var pasPairFound = resultArr.stream().
                    filter(x -> x.equals(pasPairNew)).findFirst().orElse(null);
            if (pasPairFound != null)
                return pasPairFound.getValue();
        }
        var pasPair = new PascalPair(rowIndex, colIndex);
        var pasPairFound = resultArr.stream().
                filter(x -> x.equals(pasPair)).findFirst().orElse(null);
        if (pasPairFound != null)
            return pasPairFound.getValue();

        int value1 = getValue(rowIndex - 1, colIndex - 1, resultArr);
        int value2 = getValue(rowIndex - 1, colIndex, resultArr);
        pasPair.setValue(value1 + value2);
        resultArr.add(pasPair);

        return value1 + value2;
    }*/

}

/*class PascalPair {
    private int rowIndex;
    private int colIndex;
    private int value;

    public PascalPair(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public int getValue() {
        return value;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PascalPair)) return false;
        PascalPair that = (PascalPair) o;
        return rowIndex == that.rowIndex && colIndex == that.colIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, colIndex, value);
    }
}*/

