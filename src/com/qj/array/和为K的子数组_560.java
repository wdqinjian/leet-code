package com.qj.array;

/**
 * @author qinjian
 */
public class 和为K的子数组_560 {
    public int subarraySum(int[] nums, int k) {

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