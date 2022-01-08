package com.dsa.app.level1.generictrees;

import java.util.*;

public class GenericTreeImplementation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120};
        var root = CreateGenericTree(arr);
        DisplayGenericTree(root);
        SizeGenericTree(root);
        System.out.println();
    }

    public static GTDS CreateGenericTree(int[] arr) {
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

    public static void DisplayGenericTree(GTDS root) {
        if (root == null)
            return;

        Queue<GTDS> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var element = queue.remove();

            var children = element.getChildren();
            for (int index = 0; index < children.size(); index++) {
                queue.add(children.get(index));
            }

        }
    }

    public static void SizeGenericTree(GTDS root) {
        if (root == null)
            return;

        Queue<GTDS> queue = new ArrayDeque<>();
        queue.add(root);

        int count = 1;

        while (!queue.isEmpty()) {
            var element = queue.remove();
            System.out.println(element.getValue());

            var children = element.getChildren();
            for (int index = 0; index < children.size(); index++) {
                queue.add(children.get(index));
                count++;
            }

        }
        System.out.println("Size of a tree: " + count);
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
