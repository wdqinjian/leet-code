package com.qj.array;

class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int i = solution.searchInsert(nums, target);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {

        // 二分查找
        int n = nums.length;

        int left = 0, right = n - 1, ans = n;

        while (left <= right) {
            // 计算中间的下标
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}