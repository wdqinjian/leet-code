package com.qj.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinjian
 */
public class 子集_78 {

    public static void main(String[] args) {
        子集_78 solution = new 子集_78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.subsets(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        dfs(nums, index + 1, path, res);
        path.remove(path.size() - 1);
        dfs(nums, index + 1, path, res);

    }
}