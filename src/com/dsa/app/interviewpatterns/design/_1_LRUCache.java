package com.dsa.app.interviewpatterns.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _1_LRUCache {
    public static void main(String[] args) {
    }

    private int capacity;
    private int size;
    private HashMap<Integer, LRUNode> cacheMap;
    private LRUNode head;
    private LRUNode tail;

    public _1_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new LinkedHashMap<Integer, LRUNode>();
        this.head = new LRUNode();
        this.tail = new LRUNode();
        this.head.setPost(tail);
        this.tail.setPre(head);
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key))
            return -1;

        LRUNode fetchedNode = cacheMap.get(key);
        moveNodeToHead(fetchedNode);
        return fetchedNode.getData();
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveNodeToHead(LRUNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(LRUNode node) {
        LRUNode preNode = node.getPre();
        LRUNode postNode = node.getPost();

        preNode.setPost(postNode);
        postNode.setPre(preNode);
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(LRUNode node) {
        node.setPre(head);
        node.setPost(head.post);

        head.post.setPre(node);
        head.setPost(node);
    }

    public void put(int key, int value) {
        LRUNode putNode = cacheMap.get(key);
        if (putNode != null) {
            putNode.setData(value);
            moveNodeToHead(putNode);
        } else {
            putNode = new LRUNode();
            putNode.setData(value);

            cacheMap.put(key, putNode);
            addNode(putNode);

            ++size;

            if (size > capacity) {
                LRUNode tailNode = popTail();
                cacheMap.remove(tail.getKey());
                --size;
            }
        }
    }

    private LRUNode popTail() {
        LRUNode removedNode = this.tail.getPre();
        this.removeNode(removedNode);

        return removedNode;
    }

    class LRUNode {
        private LRUNode pre;
        private LRUNode post;
        private int key;
        private int data;

        public LRUNode() {

        }

        public LRUNode getPre() {
            return pre;
        }

        public void setPre(LRUNode pre) {
            this.pre = pre;
        }

        public LRUNode getPost() {
            return post;
        }

        public void setPost(LRUNode post) {
            this.post = post;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        /**
         * access order false maintains insertion order, true maintains least recent accessed order
         */

        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
