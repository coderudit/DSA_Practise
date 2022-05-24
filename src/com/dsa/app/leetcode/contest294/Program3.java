package com.dsa.app.leetcode.contest294;

public class Program3 {
    public static void main(String[] args) {
        Program3 program = new Program3();
        int[][] stockPrices = {{36, 9}, {17, 93}, {34, 4},
                {30, 11}, {11, 41}, {53, 36}, {5, 92}, {81, 92},
                {28, 36}, {3, 45}, {72, 33}, {64, 1}, {4, 70},
                {16, 73}, {99, 20}, {49, 33}, {47, 74}, {83, 91}};

        System.out.println(program.minimumLines(stockPrices));
    }

    public int minimumLines(int[][] stockPrices) {
        int slopeChange = 1;

        for (int index = 1; index < stockPrices.length - 1; index++) {
            double x1 = stockPrices[index - 1][0];
            double y1 = stockPrices[index - 1][1];

            double x2 = stockPrices[index][0];
            double y2 = stockPrices[index][1];


            double x3 = stockPrices[index + 1][0];
            double y3 = stockPrices[index + 1][1];

            double slopeA = y2 - y1 / x2 - x1;
            double slopeB = y3 - y2 / x3 - x2;
            if (slopeA != slopeB) {
                slopeChange++;
            }

        }
        return slopeChange;
    }
}


/*
 * [[72,98],[62,27],[32,7],[71,4],[25,19],[91,30],[52,73],[10,9],[99,71],[47,22],[19,30],[80,63],[18,15],[48,17],[77,16],[46,27],[66,87],[55,84],[65,38],[30,9],[50,42],[100,60],[75,73],[98,53],[22,80],[41,61],[37,47],[95,8],[51,81],[78,79],[57,95]]*/