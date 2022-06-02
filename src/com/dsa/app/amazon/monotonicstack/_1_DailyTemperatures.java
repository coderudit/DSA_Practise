package com.dsa.app.amazon.monotonicstack;

import java.util.HashMap;
import java.util.Stack;

public class _1_DailyTemperatures {
    public static void main(String[] args) {
        _1_DailyTemperatures problem = new _1_DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        problem.dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] diffArr = new int[temperatures.length];

        Stack<TempIndex> stack = new Stack<>();
        stack.push(new TempIndex(temperatures[0], 0));
        for(int index = 1; index < temperatures.length; index++){
            while(stack.size() > 0 && stack.peek().getTemp() < temperatures[index]){
                var element = stack.pop();
                diffArr[element.getIndex()] = index-element.getIndex();
            }
            var element = new TempIndex(temperatures[index], index);
            stack.push(element);
        }

        return diffArr;
    }

    class TempIndex {
        private int temp;
        private int index;

        public TempIndex(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }

        public int getTemp() {
            return temp;
        }

        public int getIndex() {
            return index;
        }
    }
}
