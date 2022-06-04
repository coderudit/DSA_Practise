package com.dsa.app.amazon.depthfirstsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2_BoundaryOfBinaryTree {
    public static void main(String[] args) {

    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        List<Integer> left = leftBoundary(root.left);
        List<Integer> right = rightBoundary(root.right);
        List<Integer> finalList = new ArrayList<>();
        finalList.addAll(left);
        finalList.addAll(right);

        return finalList;
    }

    private List<Integer> leftBoundary(TreeNode root){
        List<Integer> leftBound = new ArrayList<>();
        while (root != null || (root.left != null && root.right!= null)) {
            leftBound.add(root.val);
            if(root.left != null){
                root = root.left;
            }else if(root.right!= null){
                root = root.right;
            }
        }
        return leftBound;
    }

    private List<Integer> leavesBoundary(TreeNode root){
        List<Integer> leftBound = new ArrayList<>();
        while (root != null) {
            if(root.left != null){
                root = root.left;
                leftBound.add(root.val);
            }else if(root.right!= null){
                root = root.right;
                leftBound.add(root.val);
            }else{
                break;
            }
        }
        return leftBound;
    }

    private List<Integer> rightBoundary(TreeNode root){
        List<Integer> rightBound = new ArrayList<>();
        while (root != null || (root.left != null && root.right!= null)) {
            rightBound.add(root.val);
            if(root.right != null){
                root = root.right;
            }else if(root.left!= null){
                root = root.left;
            }
        }
        Collections.reverse(rightBound);
        return rightBound;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
