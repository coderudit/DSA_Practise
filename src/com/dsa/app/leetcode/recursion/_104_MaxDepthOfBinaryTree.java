package com.dsa.app.leetcode.recursion;

public class _104_MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        var node1 = new TreeNode(15);
        var node2 = new TreeNode(7);
        var node3 = new TreeNode(20);
        var node4 = new TreeNode(9);
        var node5 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;
        node5.left = node4;
        node5.right = node3;
        maxDepth(node5);
    }
    private static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftVal = 1;
        int rightVal = 1;
        if(root.left != null)
            leftVal = 1 + maxDepth(root.left);
        if(root.right != null)
            rightVal = 1 + maxDepth(root.right);
        return leftVal > rightVal ? leftVal: rightVal;
    }
}
