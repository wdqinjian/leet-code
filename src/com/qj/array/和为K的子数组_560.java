package com.qj.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinjian
 */
public class 和为K的子数组_560 {

    public static void main(String[] args) {
        和为K的子数组_560 demo = new 和为K的子数组_560();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = demo.subarraySum(nums, 7);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>(nums.length + 1, 1);
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public int subarraySum1(int[] nums, int k) {

        int n = nums.length;
        int[] temp = new int[n + 1];

        temp[0] = 0;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = temp[i] + nums[i];
        }

        int num = 0;
        // 双重for 循环穷举所有的情况
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (k == temp[i] - temp[j]) {
                    num++;
                }
            }
        }

        return num;
    }
}