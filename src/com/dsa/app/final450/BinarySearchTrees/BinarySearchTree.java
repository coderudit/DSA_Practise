package com.dsa.app.final450.BinarySearchTrees;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.deleteNode(tree.root, 3);
    }

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int key) {
        insertRecord(root, key);
    }

    private Node insertRecord(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertRecord(root.left, key);
        } else {
            root.right = insertRecord(root.right, key);
        }
        return root;
    }

    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        // Key is greater than root's key
        if (root.key < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.key > key) { // Key is smaller than root's key
            root.left = deleteNode(root.left, key);
        } else {
            //No child exists for a given key
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {//Left child exists for a given key
                return root.left;
            } else if (root.right != null) {//Right child exists for a given key
                return root.right;
            } else {//Left and right child both exists for a given key
                int lmax = max(root.left);
                root.key = lmax;
                root.left = deleteNode(root.left, lmax);
                return root;
            }
        }
        return root;
    }

    private int max(Node root) {
        if (root.left == null && root.right == null)
            return root.key;
        return max(root.right);
    }
}
