package com.qj.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author qinjian
 */
public class 全排列_46 {

    public static void main(String[] args) {
        全排列_46 solution = new 全排列_46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (length < 1) {
            return result;
        }

        boolean[] used = new boolean[length];
        Deque<Integer> path = new ArrayDeque<Integer>();
        dfs(nums, length, 0, path, used, result);

        return result;
    }

    /**
     * dfs
     *
     * @param nums   原数组
     * @param length 数组的长度
     * @param depth  递归深度
     * @param path   路径
     * @param used   当前使用过的
     * @param result 结果
     */
    private void dfs(int[] nums, int length, int depth
            , Deque<Integer> path, boolean[] used, List<List<Integer>> result) {

        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }
}