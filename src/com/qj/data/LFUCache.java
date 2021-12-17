package com.qj.data;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author qinjian
 */
public class LFUCache {

    /**
     * key 到 val 的映射，称为 KV 表
     */
    private HashMap<Integer, Integer> keyToVal;
    /**
     * key 到 freq 的映射，称为 KF 表
     */
    private HashMap<Integer, Integer> keyToFreq;
    /**
     * freq 到 key 列表的映射，称为 FK 表
     */
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    /**
     * 记录最小的频次
     */
    private int minFreq;
    /**
     * 缓存的最大容量
     */
    private int capacity;

    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        // 增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {

        if (this.capacity < 1) {
            return;
        }

        // 如果key 已经存在了， 那么直接修改即可
        if (keyToVal.containsKey(key)) {
            // 维护几个值
            increaseFreq(key);
            keyToVal.put(key, value);
            return;
        }

        // 如果映射表已经满了， 则需要删除一个
        if (keyToVal.size() >= capacity) {
            removeMinFreq();
        }

        /**
         * 1、维护KV
         */
        keyToVal.put(key, value);

        /**
         * 2、维护KF
         */
        keyToFreq.put(key, 1);

        /**
         * 3、维护FK
         */
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        /**
         * 4、 维护minFreq
         */
        this.minFreq = 1;
    }

    private void removeMinFreq() {
        // 1、找到最小key 对应的key集合
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 最早添加的数据就该是被删除的那条数据
        Integer deleteKey = keyList.iterator().next();
        // 把当前key 移除掉
        keyList.remove(deleteKey);
        // 如果移除当前key后, min对应的空了，则需要在 FK 中移除
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        // 此处不需要维护 this.minFreq, 因为是添加新key才需要走到这里， 后面直接赋值1即可
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);
    }

    private void increaseFreq(int key) {

        int freq = keyToFreq.get(key);
        /**
         * 1、维护KF
         */
        keyToFreq.put(key, freq + 1);
        /**
         * 2、维护FK
         */
        // 2.1、 需要从freq中删除当前的key
        freqToKeys.get(freq).remove(key);
        // 2.2、需要把当前key 维护到 freq + 1中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        // 2.3、如果freq 对应的key都空了，需要移除
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            /**
             * 3、 维护minFreq
             */
            if (minFreq == freq) {
                // 直接加1即可， 因为 原来的minFreq 加了1，
                this.minFreq++;
            }
        }


    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */