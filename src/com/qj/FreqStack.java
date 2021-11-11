package com.qj;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    private Map<Integer, Integer> cache = null;

    private Map<Integer, Stack<Integer>> freqToKey = null;

    private int maxFreq;

    public FreqStack() {
        cache = new HashMap<>();
        freqToKey = new HashMap<>();
    }

    public void push(int val) {
        // 维护 cache
        int freq = cache.getOrDefault(val, 0) + 1;
        cache.put(val, freq);
        // 维护 freqToKey
        freqToKey.putIfAbsent(freq, new Stack());
        freqToKey.get(freq).push(val);
        // 维护最大 maxFreq
        this.maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> keyList = freqToKey.get(maxFreq);
        Integer removeValue = keyList.pop();

        cache.remove(removeValue);
        if (keyList.isEmpty()) {
            freqToKey.remove(maxFreq);

        }

        return removeValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */