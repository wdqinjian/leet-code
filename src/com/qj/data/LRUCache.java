package com.qj.data;

import java.util.LinkedHashMap;

/**
 * @author qinjian
 */
public class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> cache = null;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<>(cap);
    }

    public int get(int key) {
        // 判断key 是否存在
        if (cache.containsKey(key)) {
            // 将 key 变为最近使用
            int value = makeRecently(key);
            // 返回
            return value;
        }

        return -1;
    }

    public void put(int key, int value) {

        // 判断key 是否存在
        if (cache.containsKey(key)) {
            // 直接修改
            cache.put(key, value);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 需要先删除最久远的数据  链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        cache.put(key, value);
    }

    /**
     * 将 key 变为最近使用
     */
    private int makeRecently(int key) {
        // 先把key 删除
        int value = cache.remove(key);
        // 再重新放入
        cache.put(key, value);

        return value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */