package com.dsa.app.ooad;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1_LRUCache {
    Stack<Integer> cache = new Stack<>();
    Map<Integer, Integer> cacheEntry = new HashMap<>();
    int size = 0;
    int capacity;
    public static void main(String[] args) {

    }

    public _1_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cacheEntry.containsKey(key))
            return -1;
        return cacheEntry.get(key);
    }

    public void put(int key, int value) {
        if(cacheEntry.containsKey(key)){
            cacheEntry.put(key, value);
        }else{
            if(size == capacity){
                if(cache.size() > 0){
                    int evictedKey = cache.pop();
                    cacheEntry.remove(evictedKey);
                    cacheEntry.put(key, value);
                    size++;
                }
            }else{
                cacheEntry.put(key, value);
                size++;
            }
            cache.add(key);
        }
    }

}
class Entry{
    private int key;
    private int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

