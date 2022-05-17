package com.dsa.app.final450.BinarySearchTrees;

import java.util.Stack;

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /*tree.insert(3);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.deleteNode(tree.root, 3);*/

        int[] preOrder = {10, 5, 1, 7, 40, 50};
        tree.constructBSTFromPreorder(preOrder);

    }

    class Node {
        int key;
        Node left, right, next;

        public Node(int item) {
            key = item;
            left = right = next = null;
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
        if (root == null) return null;

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.key = min(root.right);

            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    private int max(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }

    private int min(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    public static void findPreSuc(Node root, Node p, Node s, int key) {
        if (root == null)
            return;

        if (root.key == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                p = temp;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                s = temp;
            }
        }

        if (key < root.key) {
            s = root;
            findPreSuc(root.left, p, s, key);
        } else {
            p = root;
            findPreSuc(root.right, p, s, key);
        }

    }

    public boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.key < min || root.key > max) {
            return false;
        }

        return isBSTUtil(root, min, root.key - 1) && isBSTUtil(root, root.key + 1, max);
    }

    Node next = null;

    public void populateNext(Node root) {
        if (root != null) {
            populateNext(root.right);
            root.next = next;

            next = root;
            populateNext(root.left);
        }
    }

    public Node LCA(Node root, int n1, int n2) {
        if (n1 > root.key && n2 > root.key)
            return LCA(root.right, n1, n2);
        else if (n1 < root.key && n2 < root.key)
            return LCA(root.left, n1, n2);
        else
            return root;
    }

    public Node constructBSTFromPreorder(int[] preOrder) {
        Node root = new Node(preOrder[0]);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        for (int index = 1; index < preOrder.length; index++) {
            Node temp = null;

            while (stack.size() > 0 && preOrder[index] > stack.peek().key) {
                temp = stack.pop();
            }

            if (temp != null) {
                temp.right = new Node(preOrder[index]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new Node(preOrder[index]);
                stack.push(temp.left);
            }

        }
        return root;
    }
}

