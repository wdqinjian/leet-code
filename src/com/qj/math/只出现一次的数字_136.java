package com.qj.math;

/**
 * @author qinjian
 */
public class 只出现一次的数字_136 {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}