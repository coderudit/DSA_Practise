package com.dsa.app.final450.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderandInorderTraversal {
    public static void main(String[] args) {


    }

    int index = 0;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree2(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree2(int[] preorder, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;

        int rootValue = preorder[index++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree2(preorder, startIndex, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTree2(preorder, inorderIndexMap.get(rootValue) + 1, endIndex);

        return root;
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
}
