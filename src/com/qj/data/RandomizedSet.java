package com.qj.data;

import java.util.*;

class RandomizedSet {

    Random rand = new Random();

    private List<Integer> nums;

    private Map<Integer, Integer> val2Index;

    public RandomizedSet() {
        nums = new ArrayList<>();
        val2Index = new HashMap<>();
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        System.out.println(set.getRandom());
        set.remove(1);
        set.insert(2);
        System.out.println(set.getRandom());

    }

    public boolean insert(int val) {
        if (val2Index.containsKey(val)) {
            return false;
        }

        val2Index.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (val2Index.containsKey(val)) {
            // 被移除元素的下标
            int index = val2Index.get(val);
            // 最后一个元素
            int lastVal = nums.get(nums.size() - 1);

            // 将最后一个元素的下标修改为index
            val2Index.put(lastVal, index);
            // 交换元素,修改index， 直接移除最后的元素
            nums.set(index, lastVal);

            // 移除
            val2Index.remove(val);
            nums.remove(nums.size() - 1);

            return true;
        }
        return false;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */