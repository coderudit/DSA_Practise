package com.dsa.app.amazon;

import java.util.HashMap;
import java.util.Map;

public class _6_LRUCache {

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head, tail;

    public static void main(String[] args) {

    }

    public _6_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        //Moved the access node to head
        //movetohead
        return node.val;
    }

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }

        private void addNode(Node node) {
            node.prev = head;
            node.next = head.next;
        }
    }
}


