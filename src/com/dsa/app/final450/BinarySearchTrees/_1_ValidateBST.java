package com.dsa.app.final450.BinarySearchTrees;


public class _1_ValidateBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(BinarySearchTree.TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(BinarySearchTree.TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;

        if((low!= null && root.val <= low) || (high != null && root.val >=high))
            return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}
