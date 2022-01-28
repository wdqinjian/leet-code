package com.qj.twopoint;


/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * 通过次数296,492提交次数646,717
 *
 * @author qinjian
 */
public class 最接近的三数之和_16 {

    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < length; j++) {
                // (target - num)
            }
        }

        return res;
    }
}