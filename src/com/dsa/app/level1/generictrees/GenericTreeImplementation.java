package com.dsa.app.level1.generictrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTreeImplementation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120};
        var root = createGenericTree(arr);
        System.out.println();
    }

    public static GTDS createGenericTree(int[] arr) {
        GTDS root = new GTDS(arr[0]);
        Stack<GTDS> treeStack = new Stack<>();
        treeStack.push(root);

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] == -1)
                treeStack.pop();
            else {
                GTDS newNode = new GTDS(arr[index]);
                treeStack.peek().getChildren().add(newNode);
                treeStack.add(newNode);
            }
        }
        return root;
    }
}

class GTDS {
    private int value;

    private List<GTDS> children;

    public GTDS(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(GTDS child) {
        this.children.add(child);
    }

    public List<GTDS> getChildren() {
        return this.children;
    }

    public int getValue() {
        return this.value;
    }
}
