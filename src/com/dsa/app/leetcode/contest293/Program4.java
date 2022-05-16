package com.dsa.app.leetcode.contest293;
import java.util.TreeMap;

class Program4 {

    public static void main(String[] args) {
        Program4 program = new Program4();
        String[] operations = {"CountIntervals", "add", "add", "count", "add", "count"};

        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        System.out.println(countIntervals.count());
        countIntervals.add(5, 8);
        System.out.println(countIntervals.count());
    }


}

class CountIntervals {
    private TreeMap<Integer, Interval> intervals = new TreeMap<>();

    public CountIntervals() {

    }

    public void add(int left, int right) {
        Interval interval = new Interval(left, right);
        intervals.put(left, interval);
    }

    public int count() {
        int overallInterval = 0;
        for (var key : intervals.keySet()) {
            overallInterval += intervals.get(key).getIntervalSize();
        }


        int index = 0;
        for (var key : intervals.keySet()) {
            Interval firstInterval = intervals.get(key);

            int currentIndex = index + 1;
            var values = intervals.values().toArray();
            while (currentIndex < intervals.size()) {
                Interval secondInterval = (Interval) values[currentIndex];
                //Numbers will be sorted along left side as being in treemap.
                if (firstInterval.getLeft() == secondInterval.getLeft()) { //1, 5   //1, 8
                    if (firstInterval.getRight() == secondInterval.getRight()) { //1, 5   //1, 5
                        overallInterval -= firstInterval.getIntervalSize();
                    } else if (secondInterval.getRight() > firstInterval.getRight()) {//1, 5   //1, 8
                        overallInterval -= firstInterval.getIntervalSize();
                    } else if (firstInterval.getRight() > secondInterval.getRight()) {//1, 8   //1, 5
                        overallInterval -= secondInterval.getIntervalSize();
                    }
                } else { //When next number has left greater than current number
                    if (secondInterval.getLeft() <= firstInterval.getRight()) {//When second interval starts within first interval range.
                        if (firstInterval.getRight() == secondInterval.getRight()) { //1, 5   //2, 5
                            overallInterval = overallInterval - (secondInterval.getRight() - secondInterval.getLeft());
                        } else if (firstInterval.getRight() < secondInterval.getLeft()) { //1, 5    //2, 6
                            overallInterval = overallInterval - (firstInterval.getRight() - secondInterval.getLeft());
                        } else if (secondInterval.getRight() < firstInterval.getLeft()) { //1, 5   //2, 4
                            overallInterval = overallInterval - (secondInterval.getRight() - secondInterval.getLeft());
                        } else if (firstInterval.getRight() > secondInterval.getLeft()) {
                            overallInterval = overallInterval - (firstInterval.getRight() - secondInterval.getLeft()) - 1;
                        }
                    }

                }
                currentIndex++;
            }
            index++;
        }

        return overallInterval;
    }
}

class Interval {
    private int left;
    private int right;

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getIntervalSize() {
        return right - left + 1;
    }
}
