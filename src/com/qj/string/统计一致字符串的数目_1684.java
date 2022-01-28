package com.qj.string;


import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 * <p>
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 * <p>
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * 通过次数19,172提交次数23,237
 *
 * @author qinjian
 */
public class 统计一致字符串的数目_1684 {

    public static void main(String[] args) {
        统计一致字符串的数目_1684 slou = new 统计一致字符串的数目_1684();

        try {
            System.out.println(" try");
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println(" exception");
        } finally {
            System.out.println(" finally");
        }
    }

    public int countConsistentStrings(String allowed, String[] words) {

        int len = allowed.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(allowed.charAt(i));
        }

        int ans = 0;
        len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int length = word.length();
            boolean flag = true;
            for (int j = 0; j < length; j++) {
                if (!set.contains(word.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}