package com.qj.array;

import java.util.Arrays;

/**
 * 1929. 数组串联
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 * <p>
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 * <p>
 * 返回数组 ans 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,1]
 * 输出：[1,3,2,1,1,3,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 1000
 * 通过次数16,599提交次数18,616
 *
 * @author qinjian
 */
public class 数组串联_1929 {

    public static void main(String[] args) {
        数组串联_1929 solution = new 数组串联_1929();
        int[] nums = {1, 2, 1, 4, 6};
        int[] ans = solution.getConcatenation(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + "   ,");
        }
    }

    public int[] getConcatenation(int[] nums) {
        // 原数组长度
        int length = nums.length;
        // 利用工具类拷贝， 设置长度为 2倍
        int[] ans = Arrays.copyOf(nums, length * 2);
        // 数据源是 nums, 数据源开始下标是0， 目标数组是 ans, 开始下标是 length,  赋值的长度是 length
        System.arraycopy(nums, 0, ans, length, length);
        return ans;
    }
}