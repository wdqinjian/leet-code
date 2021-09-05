package com.qj.hot100;

public class 移除元素_27 {

    public static void main(String[] args) {
        移除元素_27 demo = new 移除元素_27();

        int[] prices = {1, 2, 3, 4, 5, 6};
        demo.removeElement(prices, 9);
    }

    public int removeElement(int[] nums, int val) {

        int length = nums.length;

        int slow = 0;
        int fast = 0;

/*        while (fast < length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }*/

        for (; fast < length; fast++) {
            if (nums[fast] != val) {
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
        }
        return slow;
    }
}