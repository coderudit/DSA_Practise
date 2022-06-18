package com.dsa.app.final450.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class _2_PopulatingNextRightPointers {
    public static void main(String[] args) {

    }


    public Node connectThroughQueue(Node root) {
        if(root == null)
            return root;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();

            for(int index = 0; index < size; index++){
                Node node = queue.poll();

                if(index < size - 1)
                    node.next = queue.peek();

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
