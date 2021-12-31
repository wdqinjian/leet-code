package com.qj.array;

/**
 * 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -105 <= nums[i] <= 105
 * 1 <= k <= 109
 * 通过次数17,496提交次数89,205
 */
public class 和至少为K的最短子数组_862 {

    public static void main(String[] args) {
        和至少为K的最短子数组_862 solution = new 和至少为K的最短子数组_862();
        int[] nums = {17, 85, 93, -45, -21};
        int k = 150;

        System.out.println(solution.shortestSubarray(nums, k));
    }

    public int shortestSubarray(int[] nums, int k) {

        int length = nums.length;
        int index = length + 1;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum >= k) {
                return 1;
            }
            int j = i + 1;
            for (; j < length; j++) {
                sum += nums[j];
                if (sum >= k) {
                    index = Math.min(index, j - i + 1);
                    break;
                }
            }
//            if (sum >= k) {
//                index = Math.min(index, j + 1);
//            }
        }

        return index > length ? -1 : index;
    }
}