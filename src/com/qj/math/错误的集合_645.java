package com.qj.math;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 错误的集合_645 {

    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        boolean[] used = new boolean[length + 1];
        Arrays.fill(used, false);

        int[] result = new int[2];

        for (int i = 0; i < length; i++) {
            int value = nums[i];
            if (used[value]) {
                result[0] = value;
            }
            used[value] = true;
        }

        for (int i = 0; i <= length; i++) {
            if (!used[i]) {
                result[1] = i;
            }
        }

        return result;
    }

}