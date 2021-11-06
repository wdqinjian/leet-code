package com.qj.array;

/**
 * @author qinjian
 */
public class 两数之和II输入有序数组_167 {


    public static void main(String[] args) {
        两数之和II输入有序数组_167 demo = new 两数之和II输入有序数组_167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] arr = demo.twoSum(numbers, target);
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }


    public int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        // 暴力递归
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}