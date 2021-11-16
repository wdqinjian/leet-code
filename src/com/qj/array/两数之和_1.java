package com.qj.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinjian
 */
public class 两数之和_1 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{i, map.get(num)};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}