package com.qj.hot100;

public class 移动零_283 {

    public static void main(String[] args) {

        移动零_283 demo = new 移动零_283();

        int[] nums = {0, 2, 0, 4, 5, 6, 0, 9};
        demo.moveZeroes(nums);

        System.out.println("-----");

    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。<p>
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）<p>
     * 链接：https://leetcode-cn.com/problems/move-zeroes <p>
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                //nums[j++] = tmp;
                nums[j] = tmp;
                j++;
            }
        }
    }
}