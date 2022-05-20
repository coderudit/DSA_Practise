package com.dsa.app.level1.heap;


public class _3_IsBinaryTreeHeap {
    public static void main(String[] args) {
        _3_IsBinaryTreeHeap program = new _3_IsBinaryTreeHeap();
        Node root = new Node(50);
        root.setLeft(new Node(25));
        root.setRight(new Node(35));
        root.getLeft().setLeft(new Node(12));
        root.getLeft().setRight(new Node(17));
        root.getRight().setLeft(new Node(19));
        root.getRight().setRight(new Node(21));
        boolean isBSTHeap = program.isCompleteBinaryTree(root) && program.isMaxHeap(root);
        System.out.println(isBSTHeap);
    }

    private boolean isCompleteBinaryTree(Node tree) {
        if (tree == null)
            return true;
        if (tree.getLeft() == null && tree.getRight() == null)
            return true;
        if (tree.getLeft() == null)
            return false;
        if (tree.getRight() == null)
            return false;

        return isCompleteBinaryTree(tree.getLeft()) && isCompleteBinaryTree(tree.getRight());
    }

    private boolean isMaxHeap(Node tree) {
        if (tree == null)
            return true;
        if (tree.getLeft() == null && tree.getRight() == null)
            return true;
        if (tree.getLeft().getValue() > tree.getValue())
            return false;
        if (tree.getRight().getValue() > tree.getValue())
            return false;
        return isMaxHeap(tree.getLeft()) && isMaxHeap(tree.getRight());
    }
}


class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int item) {
        value = item;
        left = right = null;
    }
}