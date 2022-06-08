package com.dsa.app.interviewpatterns.design;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class _2_LFUCache {
    public static void main(String[] args) {
    }

    private int capacity;

    private HashMap<Integer, LFUNode> cacheMap;
    private HashMap<Integer, LFUNode> frequencyCacheMap;

    public _2_LFUCache(int capacity) {
        this.capacity = capacity;
       // this.size = 0;
        this.cacheMap = new LinkedHashMap<Integer, LFUNode>();
       // this.head = new LFUNode();
       // this.tail = new LFUNode();
       // this.head.setPost(tail);
       // this.tail.setPre(head);
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key))
            return -1;

        LFUNode fetchedNode = cacheMap.get(key);
        moveNodeToHead(fetchedNode);
        return fetchedNode.getData();
    }

    private void updateNode(LFUNode node){

    }

    /**
     * Move certain node in between to the head.
     */
    private void moveNodeToHead(LFUNode node) {
        //removeNode(node);
      //  addNode(node);
    }





    public void put(int key, int value) {
        LFUNode putNode = cacheMap.get(key);
        if (putNode != null) {
            putNode.setData(value);
            moveNodeToHead(putNode);
        } else {
            putNode = new LFUNode();
            putNode.setKey(key);
            putNode.setData(value);

            cacheMap.put(key, putNode);
         //   addNode(putNode);



           // if (size > capacity) {
             //   LFUNode tailNode = popTail();
           //     cacheMap.remove(tailNode.getKey());
             //   --size;
           // }
        }
    }



    class LFUOperations{
        private LFUNode head;
        private LFUNode tail;
        private int size;

        public int getSize() {
            return size;
        }

        /**
         * Always add the new node right after head;
         */
        private LFUNode addNode(LFUNode node) {
            node.setPre(head);
            node.setPost(head.post);

            head.post.setPre(node);
            head.setPost(node);
            size++;
            return node;
        }

        /**
         * Remove an existing node from the linked list.
         */
        private LFUNode removeNode(LFUNode node) {
            LFUNode preNode = node.getPre();
            LFUNode postNode = node.getPost();

            preNode.setPost(postNode);
            postNode.setPre(preNode);
            size--;
            return node;
        }

        private LFUNode popTail() {
            LFUNode removedNode = this.tail.getPre();
            this.removeNode(removedNode);

            return removedNode;
        }
    }

    class LFUNode {
        private LFUNode pre;
        private LFUNode post;
        private int key;
        private int data;
        private int frequency;

        public LFUNode() {
            this.frequency = -1;
        }

        public LFUNode getPre() {
            return pre;
        }

        public void setPre(LFUNode pre) {
            this.pre = pre;
        }

        public LFUNode getPost() {
            return post;
        }

        public void setPost(LFUNode post) {
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

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }
}
