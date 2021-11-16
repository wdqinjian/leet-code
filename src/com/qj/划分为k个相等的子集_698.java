package com.qj;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 划分为k个相等的子集_698 {

    public static void main(String[] args) {
        划分为k个相等的子集_698 demo = new 划分为k个相等的子集_698();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(demo.canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int length = nums.length;
        // 长度不符
        if (k > length) {
            return false;
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        // 无法均分
        if (sum % k != 0) {
            return false;
        }

        // 每个桶的目标值
        int target = sum / k;
        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
//        // 排序
//        sort(nums);
//        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
//        return backtrack1(nums, length, 0, bucket, target, k);

        // 记录已使用的元素
        boolean[] used = new boolean[length];
        return backtrack(k, 0, nums, 0, length, used, target);
    }

    private boolean backtrack(int k, int bucket, int[] nums, int start, int length, boolean[] used, int target) {

        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            // 因为 target == sum / k
            return true;
        }

        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack(k - 1, 0, nums, 0, length, used, target);
        }

        for (int i = start; i < length; i++) {
            // 已经使用的跳过
            if (used[i]) {
                continue;
            }
            // 超过目标值跳出
            if (nums[i] + bucket > target) {
                continue;
            }

            used[i] = true;
            bucket += nums[i];
            if (backtrack(k, bucket, nums, i + 1, length, used, target)) {
                return true;
            }

            // 撤销选择
            used[i] = false;
            bucket -= nums[i];
        }
        // 穷举了所有数字，都无法装满当前桶
        return false;
    }


    private void sort(int[] nums) {
        /* 降序排序 nums 数组 */
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    /**
     * 以数字的视角
     *
     * @param nums
     * @param length
     * @param index
     * @param bucket
     * @param target
     * @param k
     * @return
     */
    private boolean backtrack1(int[] nums, int length, int index, int[] bucket, int target, int k) {

        // 检查下所有的桶是否 = target
        if (length == index) {
            for (int i = 0; i < k; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < k; i++) {
            // 不停的递归调用，直到 桶的当前下表达到目标值为止
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            // 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];
            if (backtrack1(nums, length, index + 1, bucket, target, k)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }

}