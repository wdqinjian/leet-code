package com.qj;

/**
 * @author qinjian
 */
public class 最长公共前缀_14 {

    public static void main(String[] args) {
        最长公共前缀_14 demo = new 最长公共前缀_14();
        // String[] strs = {"flower", "flow", "flight"};
        // String[] strs = {"ccccc", "cc", "ccccc"};
        // String[] strs = {"abc"};
        String[] strs = {"flower", "flower", "flower", "flower"};
        System.out.println(demo.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {


        // 获取第一个元素
        String first = strs[0];

        int length = first.length();
        // 遍历整个数组， 从第二个元素开始
        for (int i = 1; i < strs.length; i++) {

            int j = 0;
            // 依次对比每一个小标的元素
            for (; j < first.length() && j < strs[i].length() && j < length; j++) {
                // 不相同处再跳出
                if (first.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            // 截断相同的部分 (此处必须用first重新赋值，  不然会以最后一个和第一个的重叠做返回， 保证first一直是前面最短的重合部分)
            first = first.substring(0, j);
            length = j;

            // 某次为空的话，不用再继续循环下去了
            if (first.equals("")) {
                return first;
            }
        }

        return first;
    }
}