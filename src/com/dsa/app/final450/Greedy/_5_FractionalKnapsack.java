package com.dsa.app.final450.Greedy;

import java.util.Arrays;

public class _5_FractionalKnapsack {
    public static void main(String[] args) {
        _5_FractionalKnapsack program = new _5_FractionalKnapsack();
        int[][] arr = {{60, 10}, {100, 20}, {120, 30}};
        int bagCapacity = 50;
        program.fillKnapsack(arr, bagCapacity);
    }

    private void fillKnapsack(int[][] arr, int bagCapacity) {
        Item[] items = new Item[arr.length];
        for (int index = 0; index < arr.length; index++) {
            items[index] = new Item(arr[index][1], arr[index][0]);
        }

        Arrays.sort(items);

        int itemIndex = 0;
        double bagValue = 0.0;
        while (bagCapacity != 0) {
            if (items[itemIndex].getWeight() <= bagCapacity) {
                bagCapacity -= items[itemIndex].getWeight();
                bagValue += items[itemIndex].getValue();
            } else {
                double fitValue = ((double)bagCapacity / items[itemIndex].getWeight()) ;
                bagCapacity -= fitValue * items[itemIndex].getWeight();
                bagValue = bagValue + fitValue * items[itemIndex].getValue();
            }
            itemIndex++;
        }
        System.out.println("Bag value: " + bagValue);
    }
}

class Item implements Comparable<Item> {
    private int weight;
    private int value;
    private double valueOfEachWeight;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double getWeightValueIndex() {
        valueOfEachWeight = this.value / this.weight;
        return valueOfEachWeight;
    }


    @Override
    public int compareTo(Item o) {
        return o.getWeightValueIndex() > this.getWeightValueIndex() ? 1 : -1;
    }
}
