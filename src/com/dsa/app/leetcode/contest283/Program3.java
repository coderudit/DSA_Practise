package com.dsa.app.leetcode.contest283;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program3 {
    private HashMap<Integer, TreeNode> treeMap;
    private HashMap<Integer, List<Integer>> nodeChildMap;

    public static void main(String[] args) {
        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        var program = new Program3();
        var root = program.createBinaryTree(descriptions);
        System.out.println();
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        treeMap = new HashMap<>();
        nodeChildMap = new HashMap<>();
        for (int rowIndex = 0; rowIndex < descriptions.length; rowIndex++) {

            TreeNode rootNode;
            int root = descriptions[rowIndex][0];
            List<Integer> childValues;

            if (!treeMap.containsKey(root)) {
                rootNode = new TreeNode(root);
                childValues = new ArrayList<>();
            } else {
                rootNode = treeMap.get(root);
                childValues = nodeChildMap.get(root);
            }

            TreeNode childNode = null;
            int child = descriptions[rowIndex][1];
            boolean childExists = false;
            if (!treeMap.containsKey(child)) {
                childNode = new TreeNode(child);
            } else {
                childNode = treeMap.get(child);
                treeMap.remove(child);
                childExists = true;
            }

            if (descriptions[rowIndex][2] == 1) {
                rootNode.left = childNode;
            } else {
                rootNode.right = childNode;
            }
            childValues.add(child);

            if (childExists) {
                childValues.addAll(nodeChildMap.get(child));
                nodeChildMap.remove(child);
            }
            int key = 1;//checkIfMapContainsNode(root, nodeChildMap);
            if (key == -1) {
                treeMap.put(root, rootNode);
                nodeChildMap.put(root, childValues);
            }else{
                treeMap.get(key);
            }
        }
        return treeMap.get(treeMap.keySet().stream().findFirst());
    }

    private boolean checkIfMapContainsNode(int root, Map<Integer, List<Integer>> nodeChildMap) {
        for (var key : nodeChildMap.keySet()) {
            if (nodeChildMap.get(key).contains(root)) {
                return true;
            }
        }
        return false;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
