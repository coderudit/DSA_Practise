package com.dsa.app.level1.generictrees;

import java.util.*;

public class GenericTreeImplementation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        var root = CreateGenericTree(arr);
        //DisplayGenericTree(root);
        //SizeGenericTree(root);
        //MaximumInGenericTree(root);
        //HeightOfGenericTree(root);
        //TraversalGenericTree(root);
        //LevelOrderTraversal(root);
        //LevelOrderLineWiseTraversal(root);
        LevelOrderZigZagTraversal(root);
        //MirrorTree(root);
        //RemoveLeavesOfTree(root);
        //Linearize(root);
        //FindAnElement(root, 120);
        /*var lst = NodeToRootPath(root, 110);
        for (var item : lst) {
            System.out.println(item);
        }*/
        //System.out.println(LowestCommonAncestor(root, 60, 100));
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
            System.out.println(element.getValue());
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

    public static void TraversalGenericTree(GTDS root) {
        if (root == null)
            return;
        System.out.println("Node Pre " + root.getValue());
        for (var child : root.getChildren()) {
            System.out.println("Edge Pre " + root.getValue() + "--" + child.getValue());
            TraversalGenericTree(child);
            System.out.println("Edge Post " + root.getValue() + "--" + child.getValue());
        }
        System.out.println("Node Post " + root.getValue());
    }

    //https://www.geeksforgeeks.org/level-order-tree-traversal/
    public static void LevelOrderTraversal(GTDS root) {
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


    public static void LevelOrderLineWiseTraversal(GTDS root) {
        if (root == null)
            return;

        Queue<GTDS> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(new GTDS(-1));

        while (!queue.isEmpty()) {
            var element = queue.remove();

            if (element.getValue() == -1) {
                System.out.println("");
            } else {
                System.out.print(element.getValue() + " ");
                if (element.getChildren().size() > 0) {
                    for (var child : element.getChildren()) {
                        queue.add(child);
                    }
                    if (queue.peek().getValue() == -1)
                        queue.add(new GTDS(-1));
                }
            }
        }
    }

    public static void LevelOrderZigZagTraversal(GTDS root) {
        if (root == null)
            return;

        var mainStack = new Stack<GTDS>();
        var childStack = new Stack<GTDS>();

        int level = 1;
        mainStack.add(root);

        while (!mainStack.isEmpty()) {
            var element = mainStack.pop();
            System.out.print(element.getValue() + " ");

            if (level % 2 == 1) {
                for (var child : element.getChildren()) {
                    childStack.push(child);
                }
            } else {
                for (int index = element.getChildren().size() - 1; index >= 0; index--) {
                    childStack.push(element.getChildren().get(index));
                }
            }


            if (mainStack.isEmpty()) {
                mainStack = childStack;
                childStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void MirrorTree(GTDS root) {
        Queue<GTDS> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            var element = queue.remove();
            System.out.println(element.getValue());

            Collections.reverse(element.getChildren());

            for (var child : element.getChildren()) {
                queue.add(child);
            }
        }
    }

    public static void RemoveLeavesOfTree(GTDS root) {
        removeLeaves(root);
        DisplayGenericTree(root);
    }

    private static boolean removeLeaves(GTDS root) {
        if (root.getChildren().size() == 0)
            return true;

        var children = root.getChildren();
        for (int index = 0; index < children.size(); index++) {
            var isLeaf = removeLeaves(children.get(index));
            if (isLeaf)
                root.getChildren().set(index, new GTDS(-1));
        }
        return false;
    }

    public static void Linearize(GTDS root) {
        if (root == null)
            return;

        System.out.println(root.getValue());
        for (var child : root.getChildren()) {
            Linearize(child);
        }

    }

    public static boolean FindAnElement(GTDS root, int key) {
        if (root.getValue() == key)
            return true;

        for (var child : root.getChildren()) {
            boolean result = FindAnElement(child, key);
            if (result)
                return true;
        }

        return false;
    }

    public static List<Integer> NodeToRootPath(GTDS root, int key) {
        if (root == null) {
            return null;
        }
        if (root.getValue() == key) {
            List<Integer> lst = new ArrayList<>();
            lst.add(key);
            return lst;
        }

        for (var child : root.getChildren()) {
            List<Integer> lst = NodeToRootPath(child, key);
            if (lst.size() > 0) {
                lst.add(root.getValue());
                return lst;
            }
        }

        return new ArrayList<>();
    }

    public static Integer LowestCommonAncestor(GTDS root, int key1, int key2) {
        var lst1 = NodeToRootPath(root, key1);
        var lst2 = NodeToRootPath(root, key2);

        int lst1Index = lst1.size() - 1;
        int lst2Index = lst2.size() - 1;
        while (lst1Index >= 0 && lst2Index >= 0 && lst1.get(lst1Index) == lst2.get(lst2Index)) {
            lst1Index--;
            lst2Index--;
        }

        return lst1.get(lst1Index + 1);

    }

    public static Integer DistanceBetweenNodes(GTDS root, int key1, int key2) {
        var lst1 = NodeToRootPath(root, key1);
        var lst2 = NodeToRootPath(root, key2);

        int lst1Index = lst1.size() - 1;
        int lst2Index = lst2.size() - 1;
        while (lst1Index >= 0 && lst2Index >= 0 && lst1.get(lst1Index) == lst2.get(lst2Index)) {
            lst1Index--;
            lst2Index--;
        }
        lst1Index++;
        lst2Index++;
        return lst1Index + lst2Index;
    }

    public static boolean AreSimilar(GTDS node1, GTDS node2) {
        if (node1.getChildren().size() != node2.getChildren().size()) {
            return false;
        }

        for (int index = 0; index < node1.getChildren().size(); index++) {
            if (!AreSimilar(node1.getChildren().get(index), node2.getChildren().get(index))) {
                return false;
            }
        }
        return true;
    }

    public static boolean AreTreesMirror(GTDS node1, GTDS node2) {
        if (node1.getChildren().size() != node2.getChildren().size()) {
            return false;
        }

        for (int index = 0; index < node1.getChildren().size(); index++) {
            if (!AreTreesMirror(node1.getChildren().get(index), node2.getChildren().get(node2.getChildren().size() - index - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsTreeSymmetric(GTDS node) {
        return AreTreesMirror(node, node);
    }

    static GTDS predecessor;
    static GTDS successor;
    static int state = 0;

    public static void PredecessorAndSuccessorOfAnElement(GTDS node, int data) {
        if (state == 0) {
            if (node.getValue() == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        } else {
            return;
        }

        for (var child : node.getChildren()) {
            PredecessorAndSuccessorOfAnElement(child, data);
        }
    }

    static int ceil;
    static int floor;

    public static void FloorAndCeilOfAnElement(GTDS node, int data) {
        if (node.getValue() > data) {
            if (node.getValue() < ceil) {
                ceil = node.getValue();
            }
        }
        if (node.getValue() < data) {
            if (node.getValue() > floor) {
                floor = node.getValue();
            }
        }

        for (var child : node.getChildren()) {
            FloorAndCeilOfAnElement(child, data);
        }
    }

    public static void KthLargestElement(GTDS node, int k) {
        //Use priority queue instead.
    }

    static int maxSum = Integer.MIN_VALUE;

    public static Integer NodeWithMaxSubtreeSum(GTDS root) {
        int subTreeSum = root.getValue();
        for (int index = 0; index < root.getChildren().size(); index++) {
            int childSum = NodeWithMaxSubtreeSum(root.getChildren().get(index));
            subTreeSum += childSum;
        }

        maxSum = Math.max(subTreeSum, maxSum);
        return subTreeSum;
    }

    public static Integer DiameterOfGenericTree(GTDS root) {
        return -1;
    }


}

class GTDS {
    private int value;

    private List<GTDS> children;

    public GTDS(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public List<GTDS> getChildren() {
        return this.children;
    }

    public int getValue() {
        return this.value;
    }
}
