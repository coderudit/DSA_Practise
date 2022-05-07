package com.dsa.app.final450.BinaryTrees;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(50);
        root.setLeft(new Node(25));
        root.getLeft().setLeft(new Node(12));
        root.getLeft().setRight(new Node(37));
        root.getLeft().getRight().setLeft(new Node(30));

        root.setRight(new Node(75));
        root.getRight().setLeft(new Node(62));
        root.getRight().setRight(new Node(87));
        root.getRight().getLeft().setRight(new Node(70));

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.DisplayBinaryTree(root);

        TreeAttributes treeAttributes = new TreeAttributes();
        treeAttributes.setHeight(binaryTree.FindSizeSumMaxAndHeightOfATree(root, treeAttributes));

        System.out.println("Height: " + treeAttributes.getHeight());
        System.out.println("Size: " + treeAttributes.getSize());
        System.out.println("Max: " + treeAttributes.getMax());
        System.out.println("Sum: " + treeAttributes.getSum());

        //binaryTree.preOrderTraversalOfBinaryTreeIterative(root);
        //var pathList = binaryTree.nodeToRootPath(root, 70);
        //for (var item : pathList) {
        //    System.out.println(item);
        //}
    }

    Node root;

    void CreateBinaryTree() {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75};
        Stack<Pair> stack = new Stack<>();
        root = new Node(arr[0]);
        Pair pr = new Pair(root, 1); //1 means left needs to fill.
        stack.push(pr);

        int index = 0;
        while (stack.size() > 0 && index < arr.length) {
            var item = stack.peek();

            /*
             * If no new node to be inserted, increment the state.
             * State 1 to 2: Left child null, Right child will be added.
             * State 2 to 3: Right child null, take out the top.
             */
            if (item.getState() == 1) {
                index++;
                if (arr[index] != null) {
                    Node left = new Node(arr[index]);
                    stack.push(new Pair(left, 1));
                    item.getNode().setLeft(left);
                } else {
                    item.getNode().setLeft(null);
                }
                item.setState(item.getState() + 1);
            } else if (item.getState() == 2) {
                index++;
                if (arr[index] != null) {
                    Node right = new Node(arr[index]);
                    stack.push(new Pair(right, 1));
                    item.getNode().setRight(right);
                } else {
                    item.getNode().setRight(null);
                }
                item.setState(item.getState() + 1);
            } else {
                stack.pop();
            }
        }


    }

    private void DisplayBinaryTree(Node root) {
        if (root == null) {
            return;
        }
        String left = root.getLeft() != null ? String.valueOf(root.getLeft().getValue()) : ".";
        String right = root.getRight() != null ? String.valueOf(root.getRight().getValue()) : ".";

        System.out.println(left + " <- " + root.getValue() + " -> " + right);

        DisplayBinaryTree(root.getLeft());

        DisplayBinaryTree(root.getRight());

    }

    private int height(Node root) {
        if (root == null)
            return -1;

        int left = height(root.getLeft());
        int right = height(root.getRight());

        return Math.max(left, right) + 1;
    }

    private int FindSizeSumMaxAndHeightOfATree(Node root, TreeAttributes treeAttributes) {
        if (root == null) {
            return -1;
        }

        treeAttributes.setSum(treeAttributes.getSum() + root.getValue());
        treeAttributes.setMax(Math.max(root.getValue(), treeAttributes.getMax()));
        treeAttributes.setSize(treeAttributes.getSize() + 1);

        int left = FindSizeSumMaxAndHeightOfATree(root.getLeft(), treeAttributes);
        int right = FindSizeSumMaxAndHeightOfATree(root.getRight(), treeAttributes);

        return Math.max(left, right) + 1;
    }

    void traversalOfBinaryTreeRecursive(Node node) {
        if (node == null)
            return;
        System.out.println("In Preorder: " + node.getValue());
        traversalOfBinaryTreeRecursive(node.getLeft());
        System.out.println("In Inorder: " + node.getValue());
        traversalOfBinaryTreeRecursive(node.getRight());
        System.out.println("In Postorder: " + node.getValue());
    }

    void levelOrderTraversalOfBinaryTree() {
        if (root == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var element = queue.remove();
            System.out.println(element.getValue());

            if (element.getLeft() != null) {
                queue.add(element.getLeft());
            }

            if (element.getRight() != null) {
                queue.add(element.getRight());
            }
        }
    }

    /*
     * Time Complexity: O(n) where n is the number of nodes in the binary tree
     * Auxiliary Space: O(n) where n is the number of nodes in the binary tree
     * */
    void reverseLevelOrderTraversalOfBinaryTree(Node root) {
        if (root == null)
            return;

        reverseLevelOrderTraversalOfBinaryTree(root.getLeft());
        System.out.println(root.getValue());
        reverseLevelOrderTraversalOfBinaryTree(root.getRight());
        System.out.println(root.getValue());
    }

    /*https://www.techiedelight.com/preorder-tree-traversal-iterative-recursive/*/
    void preOrderTraversalOfBinaryTreeIterative(Node node) {
        /*Stack<Node> stack = new Stack<>();

        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.println(node.getValue()); //Print Node
                stack.push(node);
                node = node.getLeft(); //Move left
            } else {
                node = stack.pop();
                node = node.getRight(); //Move right
            }
        }*/
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (stack.size() > 0) {
            var item = stack.pop();
            System.out.println(item.getValue());

            if (item.getRight() != null) {
                stack.push(item.getRight());
            }
            if (item.getLeft() != null) {
                stack.push(item.getLeft());
            }
        }


    }

    void reversePreOrderTraversalOfBinaryTreeIterative(Node node) {
        Stack<Node> stack = new Stack<>();

        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.println(node.getValue()); //Print Node
                stack.push(node);
                node = node.getRight(); //Move right
            } else {
                node = stack.pop();
                node = node.getLeft(); //Move left
            }
        }
    }

    void inOrderTraversalOfBinaryTreeIterative(Node node) {
        Stack<Node> stack = new Stack<>();

        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft(); //Move left
            } else {
                node = stack.pop();
                System.out.println(node.getValue()); //Print Node
                node = node.getRight(); //Move right
            }
        }
    }

    void postOrderTraversalOfBinaryTreeIterative(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        Stack<Integer> out = new Stack<>();
        while (stack.size() > 0) {
            Node curr = stack.pop();
            out.push(curr.getValue());
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getLeft());
            }

        }

        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }

    }

    List<Integer> nodeToRootPath(Node root, int key) {
        if (root.getValue() == key) {
            List<Integer> foundList = new ArrayList<>();
            foundList.add(root.getValue());
            return foundList;
        }

        if (root.getLeft() != null) {
            var returnList = nodeToRootPath(root.getLeft(), key);
            if (returnList.size() > 0) {
                returnList.add(root.getValue());
                return returnList;
            }

        }

        if (root.getRight() != null) {
            var returnList = nodeToRootPath(root.getRight(), key);
            if (returnList.size() > 0) {
                returnList.add(root.getValue());
                return returnList;
            }

        }

        return new ArrayList<>();
    }

    void printKLevelsDown(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {
            System.out.println(root.getValue());
        }
        printKLevelsDown(root.getLeft(), k - 1);
        printKLevelsDown(root.getRight(), k - 1);
    }

    List<Node> nodeToRootPathWithNodes(Node root, int key) {
        if (root.getValue() == key) {
            List<Node> foundList = new ArrayList<>();
            foundList.add(root);
            return foundList;
        }

        if (root.getLeft() != null) {
            var returnList = nodeToRootPathWithNodes(root.getLeft(), key);
            if (returnList.size() > 0) {
                returnList.add(root);
                return returnList;
            }

        }

        if (root.getRight() != null) {
            var returnList = nodeToRootPathWithNodes(root.getRight(), key);
            if (returnList.size() > 0) {
                returnList.add(root);
                return returnList;
            }

        }

        return new ArrayList<>();
    }

    void printKLevelsDownWithBlocker(Node root, int k, Node blocker) {
        if (root == null || k < 0 || root == blocker) {
            return;
        }

        if (k == 0) {
            System.out.println(root.getValue());
        }
        printKLevelsDown(root.getLeft(), k - 1);
        printKLevelsDown(root.getRight(), k - 1);
    }

    void printNodesKDistanceAway(Node root, int data, int k) {
        var path = nodeToRootPathWithNodes(root, data);

        for (int index = 0; index < path.size() && index <= k; index++) {
            printKLevelsDownWithBlocker(path.get(index), k - index, index == 0 ? null : path.get(index - 1));
        }

    }

    void printPathToLeaf(Node root, int min, int max, int sum, String psf) {
        if (root.getLeft() == null && root.getRight() == null) {
            sum += root.getValue();
            if (sum >= min && sum <= max) {
                System.out.println(psf + root.getValue());
            }
            return;
        }
        printPathToLeaf(root.getLeft(), min, max, sum + root.getValue(), psf + " " + root.getValue());
        printPathToLeaf(root.getRight(), min, max, sum + root.getValue(), psf + " " + root.getValue());
    }

    Node leftClonedTree(Node root) {
        if (root == null) {
            return null;
        }

        Node lcr = leftClonedTree(root.getLeft());
        Node rcr = leftClonedTree(root.getRight());

        var newLeftNode = new Node(root.getValue());
        newLeftNode.setLeft(lcr);
        root.setLeft(newLeftNode);
        root.setRight(rcr);

        return root;
    }

    Node removeDuplicatedFromLeftClonedTree(Node root) {
        if (root == null) {
            return null;
        }

        Node lcr = removeDuplicatedFromLeftClonedTree(root.getLeft());
        Node rcr = removeDuplicatedFromLeftClonedTree(root.getRight());

        if (root.getValue() == root.getLeft().getValue()) {
            root.setLeft(root.getLeft().getLeft());
        }
        root.setRight(rcr);

        return root;
    }

    Node removeLeaves(Node root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return null;
        }

        root.setLeft(removeLeaves(root.getLeft()));
        root.setRight(removeLeaves(root.getRight()));

        return root;
    }

    void printSingleChildNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() == null || root.getRight() == null) {
            System.out.println(root.getValue());
        }
        printSingleChildNode(root.getLeft());
        printSingleChildNode(root.getRight());
    }

    int diameterOfATree(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.getLeft()) + 1;
        int rightHeight = height(root.getRight()) + 1;

        int leftDistance = diameterOfATree(root.getLeft());
        int rightDistance = diameterOfATree(root.getRight());

        int totalDistance = Math.max(leftHeight + rightHeight + 2, Math.max(leftDistance, rightDistance));
        return totalDistance;
    }


    DiaPair diameterOfATreeEfficient(Node root) {
        if (root == null) {
            DiaPair dp = new DiaPair(-1, 0);
            return dp;
        }

        DiaPair leftDP = diameterOfATreeEfficient(root.getLeft());
        DiaPair rightDP = diameterOfATreeEfficient(root.getRight());

        DiaPair result = new DiaPair();
        result.setHeight(Math.max(leftDP.getHeight(), rightDP.getHeight()) + 1);

        result.setDiameter(Math.max(leftDP.getHeight() + rightDP.getHeight() + 2, Math.max(leftDP.getDiameter(), rightDP.getDiameter())));

        return result;
    }

}

class DiaPair {
    private int height;
    private int diameter;

    public DiaPair() {
    }

    public DiaPair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}

class Pair {
    private Node node;
    private int state;

    public Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

class TreeAttributes {
    private int size;
    private int max;
    private int sum;
    private int height;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
