package com.dsa.app.level1.generictrees;

import java.util.*;

public class GenericTreeImplementation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120};
        var root = CreateGenericTree(arr);
        //DisplayGenericTree(root);
        //SizeGenericTree(root);
        //MaximumInGenericTree(root);
        //HeightOfGenericTree(root);
        TraversalGenericTree(root);
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

            var children = element.getChildren();
            for (int index = 0; index < children.size(); index++) {
                queue.add(children.get(index));
                count++;
            }

        }
        System.out.println("Size of tree: " + count);
    }

    public static void MaximumInGenericTree(GTDS root) {
        if (root == null)
            return;

        Queue<GTDS> queue = new ArrayDeque<>();
        queue.add(root);

        int max = -1;

        while (!queue.isEmpty()) {
            var element = queue.remove();
            if (element.getValue() > max)
                max = element.getValue();

            var children = element.getChildren();

            for (int index = 0; index < children.size(); index++) {
                queue.add(children.get(index));
            }

        }
        System.out.println("Maximum value in tree: " + max);
    }

    public static void HeightOfGenericTree(GTDS root) {
        if (root == null)
            return;

        int height = genericTreeHeight(root);

        System.out.println("Height of the tree: " + height);
    }

    private static int genericTreeHeight(GTDS root) {
        if (root.getChildren().size() == 0)
            return 0;
        int max = 0;
        for (var child : root.getChildren()) {
            max = Math.max(max, genericTreeHeight(child));
        }
        return max + 1;
    }

    public static void TraversalGenericTree(GTDS root){
        if(root == null)
            return;
        System.out.println("Node Pre " + root.getValue());
        for(var child: root.getChildren()){
            System.out.println("Edge Pre " + root.getValue() + "--" + child.getValue());
            TraversalGenericTree(child);
            System.out.println("Edge Post " + root.getValue() + "--" + child.getValue());
        }
        System.out.println("Node Post " + root.getValue());
    }

    public static void LevelOrderTraversal(GTDS root){
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
