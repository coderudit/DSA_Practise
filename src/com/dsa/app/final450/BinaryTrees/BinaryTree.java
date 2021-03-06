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

        BinarySearchTree binaryTree = new BinarySearchTree();
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

        int[] arr = {-1, 1, 2, 3, 4, 5, 6, 7};
        BinaryTree tree = new BinaryTree();
        Node root = null;
        tree.BuildTree(root, arr, 1);
        System.out.println();
        Node leftViewRoot = new Node(10);
        leftViewRoot.setLeft(new Node(2));
        leftViewRoot.setRight(new Node(3));
        leftViewRoot.getLeft().setLeft(new Node(7));
        leftViewRoot.getLeft().setRight(new Node(8));
        leftViewRoot.getRight().setRight(new Node(15));
        leftViewRoot.getRight().setLeft(new Node(12));
        leftViewRoot.getRight().getRight().setLeft(new Node(14));
        BinaryTree binaryTree = new BinaryTree();
        var list = binaryTree.verticalOrderTraversal(leftViewRoot);
        System.out.println(list);
        /*BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.leftViewOfTree(leftViewRoot);*/

        //BinaryTree binaryTree = new BinaryTree();
        //binaryTree.binaryTreeFromString("4(2(1)(3))(6(5))");

        int[] inOrder = {3, 1, 4, 0, 5, 2};
        int[] preOrder = {0, 1, 3, 4, 2, 5};
        binaryTree.createTree(inOrder, preOrder);
    }

    Node root;

    private Node BuildTree(Node treeroot, int[] arr, int index) {
        if (index == arr.length)
            return null;

        treeroot = new Node(arr[index]);
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;
        if (leftChild < arr.length) {
            treeroot.setLeft(BuildTree(null, arr, leftChild));
        } else {
            return treeroot;
        }

        if (rightChild < arr.length) {
            treeroot.setRight(BuildTree(null, arr, rightChild));
        } else {
            return treeroot;
        }
        return treeroot;
    }

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

    //Love babbar
    void countNumberOfLeafNodes(Node root, int count) {
        if (root == null)
            return;

        countNumberOfLeafNodes(root.getLeft(), count);
        if (root.getLeft() == null && root.getRight() == null)
            count++;
        countNumberOfLeafNodes(root.getRight(), count);
    }

    //Love babbar
    private int height(Node root) {
        if (root == null)
            return -1;

        int left = height(root.getLeft());
        int right = height(root.getRight());

        return Math.max(left, right) + 1;
    }

    //Love babbar
    int diameterOfATree(Node root) {
        if (root == null)
            return 0;

        int leftDiameter = diameterOfATree(root.getLeft());
        int rightDiameter = diameterOfATree(root.getRight());
        int totalHeight = height(root.getLeft()) + height(root.getRight()) + 1;

        return Math.max(totalHeight, Math.max(leftDiameter, rightDiameter));
    }

    //Love babbar
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

    int max = 0;

    //Love babbar
    public int diameterOfBinaryTreeOptimized(Node root) {
        heightDia(root);
        return max;
    }

    //Love babbar
    // the diameter is nothing but the max height of left + max height of right
    int heightDia(Node root) {
        //Base case
        if (root == null) {
            return 0;
        }
        int left = heightDia(root.getLeft());   // max height of left subtree
        int right = heightDia(root.getRight()); // max height of right subtree
        max = Math.max(left + right + 1, max); // updating max before returning the value
        return Math.max(left, right) + 1;// returning the max height
    }

    //Love babbar
    public boolean isTreeBalanced(Node root) {
        int diff = heightModified(root);
        return diff == -1 ? false : true;
    }

    //Love babbar
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

    //Love babbar
    public boolean areTreesIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 != null || root2 != null)
            return false;

        return root1.getValue() == root2.getValue() && areTreesIdentical(root1.getLeft(), root2.getLeft())
                && areTreesIdentical(root1.getRight(), root2.getRight());
    }

    //Love babbar
    public boolean isSumTree(Node root) {
        return isSumTreeUtil(root).isSumTree();
    }

    //Love babbar
    public SumTreePair isSumTreeUtil(Node root) {
        if (root.getLeft() == null && root.getRight() == null)
            return new SumTreePair(true, root.getValue());

        var leftTree = isSumTreeUtil(root.getLeft());
        var rightTree = isSumTreeUtil(root.getRight());

        int childSum = leftTree.getSum() + rightTree.getSum();

        var currentTree = new SumTreePair(childSum == root.getValue(), root.getValue());
        return currentTree;
    }

    //Love babbar
    public void boundaryTraversal(Node root) {
        List<Integer> traversalList = new ArrayList<>();
    }

    //Love babbar
    private void leftBoundaryTraversal(Node root, List<Integer> traversalList) {
        while (root == null || (root.getLeft() != null && root.getRight() != null)) {
            traversalList.add(root.getValue());
            if (root.getLeft() != null)
                root = root.getLeft();
            else
                root = root.getRight();
        }
    }

    //Love babbar
    private void addLeaves(Node root, List<Integer> traversalList) {
        if (root.getLeft() == null && root.getRight() == null) {
            traversalList.add(root.getValue());
        }
        addLeaves(root.getLeft(), traversalList);
        addLeaves(root.getRight(), traversalList);
    }

    //Love babbar
    private void rightBoundaryTraversal(Node root, List<Integer> traversalList) {
        List<Integer> tempList = new ArrayList<>();
        while (root == null || (root.getLeft() != null && root.getRight() != null)) {
            tempList.add(root.getValue());
            if (root.getRight() != null)
                root = root.getRight();
            else
                root = root.getLeft();
        }

        for (int index = tempList.size() - 1; index >= 0; index--) {
            traversalList.add(tempList.get(index));
        }
    }

    //Love Babbar
    public Map<Integer, List<Integer>> verticalOrderTraversal(Node root) {
        Map<Integer, List<Integer>> outerValues = new HashMap<>();
        verticalOrderTraversalUtil(root, 0, outerValues);
        return outerValues;
    }

    //Love Babbar
    private void verticalOrderTraversalUtil(Node root, int level, Map<Integer, List<Integer>> outerValues) {
        if (root == null)
            return;

        if (!outerValues.containsKey(level)) {
            outerValues.put(level, new ArrayList<>());
        }

        outerValues.get(level).add(root.getValue());
        verticalOrderTraversalUtil(root.getLeft(), level - 1, outerValues);
        verticalOrderTraversalUtil(root.getRight(), level + 1, outerValues);


    }

    //Love Babbar
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

    //Love Babbar
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

    //Love Babbar
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

    //Love Babbar
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

    //Love Babbar
    private void leftViewOfTreeUtil(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (list.size() < level) {
            list.add(root.getValue());
        }
        leftViewOfTreeUtil(root.getLeft(), level + 1, list);
        leftViewOfTreeUtil(root.getRight(), level + 1, list);
    }

    //Love Babbar
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

    //Love Babbar
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

    //Love Babbar
    private void rightViewOfTreeUtil(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (list.size() < level) {
            list.add(root.getValue());
        }

        rightViewOfTreeUtil(root.getRight(), level + 1, list);
        rightViewOfTreeUtil(root.getLeft(), level + 1, list);
    }

    //Love Babbar
    class BloodLinePair {
        int sum;
        int height;

        public BloodLinePair() {
        }

        public BloodLinePair(int sum, int height) {
            this.sum = sum;
            this.height = height;
        }
    }

    //Love Babbar
    public BloodLinePair sumOfTheLongestBloodLine(Node root) {
        if (root == null)
            return new BloodLinePair(0, 0);

        BloodLinePair leftPair = sumOfTheLongestBloodLine(root.getLeft());
        BloodLinePair rightPair = sumOfTheLongestBloodLine(root.getRight());

        BloodLinePair rootPair = new BloodLinePair();
        if (leftPair.height > rightPair.height)
            rootPair.height = leftPair.height + 1;
        else
            rootPair.height = rightPair.height + 1;

        rootPair.sum = leftPair.sum + rightPair.sum + 1;
        return rootPair;
    }

    //Love Babbar
    public void sumOfTheLongestBloodLine(Node root, int length, int maxLength, int sum, int maxSum) {
        if (root == null) {
            if (length > maxLength) {
                length = maxLength;
                sum = maxSum;
            } else if (length == maxLength)
                maxSum = Math.max(sum, maxSum);
            return;
        }

        sum = sum + root.getValue();
        sumOfTheLongestBloodLine(root.getLeft(), length + 1, maxLength, sum, maxSum);
        sumOfTheLongestBloodLine(root.getRight(), length + 1, maxLength, sum, maxSum);
    }

    public Node LowestCommonAncestor(Node root, Node p, Node q){
        if(root== null)
            return null;
        if(root.getValue() == p.getValue() || root.getValue() == q.getValue())
            return root;
        Node left = LowestCommonAncestor(root.getLeft(), p, q);
        Node right = LowestCommonAncestor(root.getRight(), p, q);

        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        return null;
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

    // Section: Level order traversal start
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

    List<List<Integer>> levelOrderTraversalAsListForBinaryTree() {
        var values = new ArrayList<List<Integer>>();

        if (root == null)
            return values;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            List<Integer> innerValues = new ArrayList<>();

            while (count < size) {
                var element = queue.remove();
                innerValues.add(element.getValue());

                if (element.getLeft() != null) {
                    queue.add(element.getLeft());
                }

                if (element.getRight() != null) {
                    queue.add(element.getRight());
                }
                count++;
            }
            values.add(innerValues);
        }
        return values;
    }

    public List<List<Integer>> levelOrderTraversalList(Node root) {
        List<List<Integer>> outerList = new ArrayList<>();
        LevelOrderTraversalUtil(root, outerList, 0);
        return outerList;
    }

    private static void LevelOrderTraversalUtil(Node root, List<List<Integer>> outerList, int level) {
        if (root == null)
            return;

        if (level >= outerList.size()) {
            outerList.add(new ArrayList<>());
        }

        outerList.get(level).add(root.getValue());

        LevelOrderTraversalUtil(root.getLeft(), outerList, level + 1);
        LevelOrderTraversalUtil(root.getRight(), outerList, level + 1);
    }

    // Level order traversal ends

    /*
     * Time Complexity: O(n) where n is the number of nodes in the binary tree
     * Auxiliary Space: O(n) where n is the number of nodes in the binary tree
     * */
    void reverseLevelOrderTraversalOfBinaryTree(Node node) {
        Stack<Node> S = new Stack();
        Queue<Node> Q = new LinkedList();
        Q.add(node);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false) {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);

            /* Enqueue right child */
            if (node.getRight() != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.getRight());

            /* Enqueue left child */
            if (node.getLeft() != null)
                Q.add(node.getLeft());
        }

        // Now pop all items from stack one by one and print them
        while (S.empty() == false) {
            node = S.peek();
            System.out.print(node.getValue() + " ");
            S.pop();
        }
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal/discuss/2030270/Java-recursive-solution
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/2030283/Java-recursive-solution-without-reverse
    List<List<Integer>> reverseLevelOrderTraversalList(Node node) {
        var values = new ArrayList<List<Integer>>();

        if (node == null)
            return values;

        Stack<Node> S = new Stack();
        Queue<Node> Q = new LinkedList();
        Q.add(node);

        while (Q.isEmpty() == false) {
            int n = Q.size();
            int count = 0;

            while (count < n) {
                node = Q.remove();
                S.push(node);

                /* Enqueue right child */
                if (node.getRight() != null)
                    // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                    Q.add(node.getRight());

                /* Enqueue left child */
                if (node.getLeft() != null)
                    Q.add(node.getLeft());

                count++;
            }

            List<Integer> innerValues = new ArrayList<>();
            while (S.size() > 0) {
                innerValues.add(S.pop().getValue());
            }
            values.add(innerValues);
        }
        Collections.reverse(values);
        return values;
    }

    public List<List<Integer>> reverseLevelOrderTraversal(Node root) {
        List<List<Integer>> outerList = new ArrayList<>();
        LevelOrderTraversalUtil(root, outerList, 0);
        return outerList;
    }

    private static void reverseLevelOrderTraversalUtil(Node root, List<List<Integer>> outerList, int level) {
        if (root == null)
            return;

        if (level >= outerList.size()) {
            outerList.add(new ArrayList<>());
        }

        LevelOrderTraversalUtil(root.getLeft(), outerList, level + 1);
        LevelOrderTraversalUtil(root.getRight(), outerList, level + 1);

        outerList.get(level).add(root.getValue());
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
        if (root1 == null)
            return false;

        if (root2 == null)
            return true;


        if (areIdentical(root1, root2))
            return true;

        return isSubTree(root1.getLeft(), root2) || isSubTree(root1.getRight(), root2);
    }


    private boolean areIdentical(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }

        return root.getValue() == root2.getValue() && areIdentical(root1.getLeft(), root2.getLeft()) && areIdentical(root1.getRight(), root.getRight());
    }


    // Binary tree matching section ends


    public int sumOfLongRootToLeafPath(Node root) {
        sumOfLongRootToLeafPathUtil(root, 0, 0);
        return maxSum;
    }

    int longestPath = 0;
    int maxSum = 0;

    private void sumOfLongRootToLeafPathUtil(Node root, int pathLength, int sum) {
        if (root == null) {
            if (pathLength >= longestPath) {
                longestPath = pathLength;
                maxSum = Math.max(sum, maxSum);
            }
        }
        sumOfLongRootToLeafPathUtil(root.getLeft(), pathLength + 1, sum + root.getValue());
        sumOfLongRootToLeafPathUtil(root.getRight(), pathLength + 1, sum + root.getValue());
    }
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

class SumTreePair {
    private boolean isSumTree;
    private int sum;

    public SumTreePair(boolean isSumTree, int sum) {
        this.isSumTree = isSumTree;
        this.sum = sum;
    }

    public boolean isSumTree() {
        return isSumTree;
    }

    public void setSumTree(boolean sumTree) {
        isSumTree = sumTree;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
