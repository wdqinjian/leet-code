package com.qj.book;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinjian
 */
public class 存在重复元素_217 {


    public boolean containsDuplicate(int[] nums) {

        int length = nums.length;

        if (length < 2) {
            return false;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            numSet.add(nums[i]);
        }

        return length != numSet.size();
    }
}