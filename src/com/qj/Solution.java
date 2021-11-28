package com.qj;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + "   ");
        }

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        int m = nums2.length;

        for (int i = 0; i < n; i++) {

            int j = 0;
            while (j < m && nums1[i] != nums2[j]) {
                j++;
            }

            j = j + 1;
            while (j < m && nums2[j] < nums1[i]) {
                j++;
            }
            result[i] = j < m ? nums2[j] : -1;
        }
        return result;
    }


    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            int num = nums1[i];
            int j = 0;
            for (; j < m; j++) {
                if (nums2[j] == num) {
                    j++;
                    break;
                }
            }
            if (j < m) {
                while (j < m && nums2[j] <= nums1[i]) {
                    j++;
                }
                result[i] = j < m ? nums2[j] : -1;
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}