package com.dsa.app.level1.linkedlists;

import java.util.LinkedList;

public class _2_LLToStackAdapter {
    LinkedList<Integer> list;

    public _2_LLToStackAdapter() {
        list = new LinkedList<>();
    }

    int size() {
        return list.size();
    }

    void push(int value) {
        list.addFirst(value);
    }

    int pop() {
        if (size() == 0) {
            return -1;
        }
        return list.removeFirst();
    }

    int top() {
        if (size() == 0)
            return -1;
        return list.getFirst();
    }
}
