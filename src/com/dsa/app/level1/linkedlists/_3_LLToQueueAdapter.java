package com.dsa.app.level1.linkedlists;

import java.util.LinkedList;

public class _3_LLToQueueAdapter {
    LinkedList<Integer> list;

    public _3_LLToQueueAdapter() {
        list = new LinkedList<Integer>();
    }

    int size() {
        return list.size();
    }

    void add(int value) {
        list.addLast(value);
    }

    int remove() {
        if (size() == 0)
            return -1;
        return list.removeFirst();
    }

    int peek() {
        if(size() == 0)
            return -1;
        return list.getFirst();
    }
}
