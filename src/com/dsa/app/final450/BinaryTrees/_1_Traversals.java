package com.dsa.app.final450.BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.*;

public class _1_Traversals {
    public class TreeNode {
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

    public static void main(String[] args) {

    }

    public List<Integer> preorderIterativeTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            var currentNode = stack.pop();
            output.add(currentNode.val);
            if (currentNode.right != null) {
                stack.add(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.add(currentNode.left);
            }
        }
        return output;
    }

    public List<Integer> preorderMorrisTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                output.add(root.val);
                root = root.right;
            } else {
                TreeNode predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    output.add(root.val);
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    root = root.right;
                }
            }

        }
        return output;
    }

    public List<Integer> inorderIterativeTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        return output;
    }

    public List<Integer> inorderMorrisTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        while (root != null) {
            if (root.left == null) {
                output.add(root.val);
                root = root.right;
            } else {
                TreeNode predecessor = root.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            }
        }

        return output;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // go to next level
            level++;
        }
        return levels;
    }
}
