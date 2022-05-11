package com.dsa.app.final450.BinaryTrees;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        /*Node root = new Node(50);
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
        System.out.println("Sum: " + treeAttributes.getSum());*/

        //binaryTree.preOrderTraversalOfBinaryTreeIterative(root);
        //var pathList = binaryTree.nodeToRootPath(root, 70);
        //for (var item : pathList) {
        //    System.out.println(item);
        //}


        /*Node leftViewRoot = new Node(10);
        leftViewRoot.setLeft(new Node(2));
        leftViewRoot.setRight(new Node(3));
        leftViewRoot.getLeft().setLeft(new Node(7));
        leftViewRoot.getLeft().setRight(new Node(8));
        leftViewRoot.getRight().setRight(new Node(15));
        leftViewRoot.getRight().setLeft(new Node(12));
        leftViewRoot.getRight().getRight().setLeft(new Node(14));

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.leftViewOfTree(leftViewRoot);*/

        BinaryTree binaryTree = new BinaryTree();
        //binaryTree.binaryTreeFromString("4(2(1)(3))(6(5))");

        int[] inOrder = {3, 1, 4, 0, 5, 2};
        int[] preOrder = {0, 1, 3, 4, 2, 5};
        binaryTree.createTree(inOrder, preOrder);
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

    static int totalTilt = 0;

    int tiltOfTheTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftTilt = tiltOfTheTree(root.getLeft());
        int rightTilt = tiltOfTheTree(root.getRight());

        int diff = Math.abs(leftTilt - rightTilt);
        totalTilt += diff;

        return leftTilt + rightTilt + root.getValue();
    }

    public void leftViewOfTree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int index = 1; index <= n; index++) {
                var node = queue.poll();

                if (index == 1) {
                    System.out.println(node.getValue());
                }

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }

    }

    public List<Integer> leftViewOfTreeOptimized(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> leftViewList = new ArrayList<>();
        leftViewOfTreeUtil(root, 1, leftViewList);
        for (var item : leftViewList) {
            System.out.println(item);
        }
        return leftViewList;
    }

    private void leftViewOfTreeUtil(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (list.size() < level) {
            list.add(root.getValue());
        }
        leftViewOfTreeUtil(root.getLeft(), level + 1, list);
        leftViewOfTreeUtil(root.getRight(), level + 1, list);
    }

    public void rightViewOfTree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            boolean firstOcurence = true;
            for (int index = n; index >= 1; index--) {
                var node = queue.poll();
                if (firstOcurence) {
                    System.out.println(node.getValue());
                    firstOcurence = false;
                }

                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }

            }
        }
    }

    public List<Integer> rightViewOfTreeOptimized(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> rightViewList = new ArrayList<>();
        rightViewOfTreeUtil(root, 1, rightViewList);
        for (var item : rightViewList) {
            System.out.println(item);
        }
        return rightViewList;
    }

    private void rightViewOfTreeUtil(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (list.size() < level) {
            list.add(root.getValue());
        }

        rightViewOfTreeUtil(root.getRight(), level + 1, list);
        rightViewOfTreeUtil(root.getLeft(), level + 1, list);
    }

    public List<Integer> topViewOfTree(Node root) {
        if (root == null)
            return null;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TopViewPair> queue = new LinkedList<>();
        queue.add(new TopViewPair(root, 0));

        while (queue.size() > 0) {
            var item = queue.remove();
            if (!map.containsKey(item.getHorizontalDistance())) {
                map.put(item.getHorizontalDistance(), item.getNode().getValue());
            }

            if (root.getLeft() != null)
                queue.add(new TopViewPair(root.getLeft(), item.getHorizontalDistance() - 1));

            if (root.getRight() != null)
                queue.add(new TopViewPair(root.getRight(), item.getHorizontalDistance() + 1));
        }
        List<Integer> lst = new ArrayList<>();
        for (var item : map.keySet()) {
            lst.add(map.get(item));
        }
        return lst;
    }

    public List<Integer> bottomViewOfTree(Node root) {
        if (root == null)
            return null;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TopViewPair> queue = new LinkedList<>();
        queue.add(new TopViewPair(root, 0));

        while (queue.size() > 0) {
            var item = queue.remove();
            map.put(item.getHorizontalDistance(), item.getNode().getValue());

            if (root.getLeft() != null)
                queue.add(new TopViewPair(root.getLeft(), item.getHorizontalDistance() - 1));

            if (root.getRight() != null)
                queue.add(new TopViewPair(root.getRight(), item.getHorizontalDistance() + 1));
        }
        List<Integer> lst = new ArrayList<>();
        for (var item : map.keySet()) {
            lst.add(map.get(item));
        }
        return lst;
    }

    public boolean isTreeBalanced(Node root) {
        int diff = heightModified(root);
        return diff == -1 ? false : true;
    }

    private int heightModified(Node root) {
        if (root == null)
            return 0;

        int left = heightModified(root.getLeft());
        int right = heightModified(root.getRight());
        if (left == -1 || right == -1)
            return -1;

        int diff = Math.abs(left - right);

        return diff > 1 ? -1 : Math.max(left, right) + 1;
    }

    public void diagonalTree(Node root) {
        Queue<Node> mainQueue = new LinkedList<>();
        mainQueue.add(root);

        Map<Integer, List<Integer>> map = new HashMap<>();
        int level = 0;
        map.put(level, new ArrayList<>());


        while (mainQueue.size() > 0) {
            int sizeOfQueue = mainQueue.size();

            List<Integer> currentDiagonalList = new ArrayList<>();

            while (sizeOfQueue > 0) {
                var currentNode = mainQueue.remove();

                while (currentNode != null) {
                    currentDiagonalList.add(currentNode.getValue());

                    if (currentNode.getLeft() != null) {
                        mainQueue.add(currentNode.getLeft());
                    }

                    currentNode = currentNode.getRight();
                }
            }

            map.put(level, currentDiagonalList);
            level++;

        }
    }

    public void boundaryTraversal(Node root) {
        List<Integer> traversalList = new ArrayList<>();
    }

    private boolean isLeaf(Node root) {
        return root.getLeft() == null && root.getRight() == null;
    }

    private void leftBoundaryTraversal(Node root, List<Integer> traversalList) {
        while (root.getLeft() != null && root.getRight() != null) {
            traversalList.add(root.getValue());
            if (root.getLeft() != null)
                root = root.getLeft();
            else
                root = root.getRight();
        }
    }

    private void addLeaves(Node root, List<Integer> traversalList) {
        if (root == null) {
            traversalList.add(root.getValue());
        }
        addLeaves(root.getLeft(), traversalList);
        addLeaves(root.getRight(), traversalList);
    }

    private void rightBoundaryTraversal(Node root, List<Integer> traversalList) {
        List<Integer> tempList = new ArrayList<>();
        while (root.getLeft() != null && root.getRight() != null) {
            tempList.add(root.getValue());
            if (root.getLeft() != null)
                root = root.getRight();
            else
                root = root.getLeft();
        }

        for (int index = tempList.size() - 1; index >= 0; index--) {
            traversalList.add(tempList.get(index));
        }
    }

    //-4(2(1)(3))(6(5))
    private Node binaryTreeFromString(String str) {
        if (str == null || str.length() == 0)
            return null;

        Stack<Node> stack = new Stack<>();
        for (int index = 0; index < str.length(); index++) {
            Character c = str.charAt(index);
            if (str.charAt(index) != ')') {
                // stack.push(str.charAt(index));
            } else {
                stack.pop();
            }
        }
        return stack.pop();
    }

    Node btPrev = null;
    Node btHead = null;

    private void binaryTreeToDoublyLinkedList(Node root) {
        if (root == null)
            return;

        binaryTreeToDoublyLinkedList(root.getLeft());

        if (btPrev == null) {
            btHead = root;
        } else {
            root.setLeft(btPrev);
            btPrev.setRight(root);
        }
        btPrev = root;
        binaryTreeToDoublyLinkedList(root.getRight());
    }


    public Node createTree(int[] inOrder, int[] preOrder) {
        return createTreeHelper(inOrder, preOrder, 0, inOrder.length);
    }

    private static int currentIndex = 0;

    private Node createTreeHelper(int[] inOrder, int[] preOrder, int startIndex, int endIndex) {
        if (currentIndex >= preOrder.length)
            return null;

        Node node = new Node(preOrder[currentIndex]);
        currentIndex++;

        if (startIndex == endIndex)
            return node;

        int mid = linearSearch(inOrder, node.getValue());
        node.setLeft(createTreeHelper(inOrder, preOrder, startIndex, mid - 1));
        node.setRight(createTreeHelper(inOrder, preOrder, mid + 1, endIndex));

        return node;
    }

    private int linearSearch(int[] items, int key) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == key)
                return i;
        }
        return -1;
    }

    public void TransformToSumTree(Node node) {
        TransformToSumTreeHelper(node);
    }

    private int TransformToSumTreeHelper(Node node) {
        if (node == null)
            return 0;

        int oldValue = node.getValue();
        int leftValue = TransformToSumTreeHelper(node.getLeft());
        int rightValue = TransformToSumTreeHelper(node.getRight());
        node.setValue(leftValue + rightValue);

        return node.getValue() + oldValue;
    }

    // Binary tree matching section starts
    //1. Check if a binary tree is subtree of another binary tree | Set 1
    //Worst case complexity: O(nm) i.e. O(n*n)
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if(areIdentical(root1, root2))
            return true;

        return isSubTree(root1.getLeft(), root2) || isSubTree(root1.getRight(), root2);
    }


    private boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return root.getValue() == root2.getValue() && areIdentical(root1.getLeft(), root2.getLeft()) && areIdentical(root1.getRight(), root.getRight());
    }

    // Binary tree matching section ends
}

class TopViewPair {
    private Node node;
    private int horizontalDistance;

    public TopViewPair(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getHorizontalDistance() {
        return horizontalDistance;
    }

    public void setHorizontalDistance(int horizontalDistance) {
        this.horizontalDistance = horizontalDistance;
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
