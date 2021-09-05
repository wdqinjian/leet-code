package com.qj.book;

public class 旋转数组_189 {

    public static void main(String[] args) {
        旋转数组_189 demo = new 旋转数组_189();

        int[] prices = {7, 1, 5, 3, 6, 4};
        demo.rotate(prices, 3);
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];

        for (int i = 0; i < length; i++) {
            // 取模拿到新的下标
            int index = (i + k) % length;
            newNums[index] = nums[i];
        }

        System.out.println("iiii");

        nums = newNums;
    }
}