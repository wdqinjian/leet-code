package com.qj.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author qinjian
 */
public class 找到所有数组中消失的数字_448 {
    public static void main(String[] args) {
        找到所有数组中消失的数字_448 solution = new 找到所有数组中消失的数字_448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = solution.findDisappearedNumbers(nums);

        System.out.println(list);

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int length = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0));
        }

        for (int i = 1; i <= length; i++) {
            if (map.containsKey(i)) {
                continue;
            }
            result.add(i);
        }

        return result;
    }
}