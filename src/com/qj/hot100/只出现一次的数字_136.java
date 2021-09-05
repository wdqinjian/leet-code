package com.qj.hot100;

/**
 * @author qinjian
 */
public class 只出现一次的数字_136 {

    public static void main(String[] args) {
        只出现一次的数字_136 demo = new 只出现一次的数字_136();

        int[] nums = {0, 2, 0, 5, 5, 9, 9};
        int i = demo.singleNumber(nums);

        System.out.println(i);
    }


    public int singleNumber(int[] nums) {

        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;

/*        // 1、利用hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            count = count == null ? 1 : count + 1;
            map.put(nums[i], count);
        }

        for (Integer integer : map.keySet()) {
            if (1 == map.get(integer)) {
                return integer;
            }
        }
        return 0;*/
    }
}