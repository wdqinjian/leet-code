package com.qj.array;

/**
 * @author qinjian
 */
public class 最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {

        // 数组长度
        int length = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < length - 2; i++) {
            for (int j = 1; j < length - 1; j++) {
                for (int k = 2; k < length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    Math.min(Math.abs(num - target), result);
                }
            }
        }

        return result;
    }
}