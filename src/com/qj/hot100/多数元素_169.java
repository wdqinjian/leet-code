package com.qj.hot100;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 多数元素_169 {

    public static void main(String[] args) {
        多数元素_169 solution = new 多数元素_169();
        int[] nums = {3};
        System.out.println(solution.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int half = length / 2;

        int count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
                if (count >= half) {
                    return nums[i];
                }
            } else {
                count = 0;
            }
        }

        return 0;
    }
}