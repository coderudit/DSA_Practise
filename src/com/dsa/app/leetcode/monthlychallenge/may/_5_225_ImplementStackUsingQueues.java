package com.dsa.app.leetcode.monthlychallenge.may;

import java.util.ArrayDeque;
import java.util.Queue;

public class _5_225_ImplementStackUsingQueues {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public static void main(String[] args) {

    }

    public _5_225_ImplementStackUsingQueues() {

    }

    public void optimizedPush(int x) {
        queue1.add(x);
        int sz = queue1.size();
        while (sz > 1) {
            queue1.add(queue1.remove());
            sz--;
        }
    }

    public void push(int x) {
        if (queue1.size() == 0) {
            queue1.add(x);
        } else {
            while (queue1.size() > 0) {
                queue2.add(queue1.remove());
            }
            queue1.add(x);
            while (queue2.size() > 0) {
                queue1.add(queue2.remove());
            }
        }
    }

    public int pop() {
        if(empty())
            return -1;
        return queue1.remove();
    }

    public int top() {
        if(empty())
            return -1;
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.size() == 0;
    }
}


