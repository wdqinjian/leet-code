package com.qj.math;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 丢失的数字_268 {

    public static void main(String[] args) {
        丢失的数字_268 demo = new 丢失的数字_268();
        int[] nums = {1, 0, 3};
        int i = demo.missingNumber(nums);
        System.out.println(i);

    }

    public int missingNumber(int[] nums) {

        int n = nums.length;

        int sum = ((n + 1) * n) / 2;

        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }

        return sum;
    }

    public int missingNumber1(int[] nums) {

        int length = nums.length;
        boolean[] temp = new boolean[length + 1];
        Arrays.fill(temp, false);

        for (int i = 0; i < length; i++) {
            temp[nums[i]] = true;
        }

        for (int i = 0; i <= length; i++) {
            if (temp[i]) {
                return i;
            }
        }

        return 0;
    }
}