package com.qj.string;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 *
 * @author qinjian
 */
public class 最后一个单词的长度_58 {

    public static void main(String[] args) {

        最后一个单词的长度_58 solution = new 最后一个单词的长度_58();
        String s = "   fly me   to   the moon  ";
        int length = solution.lengthOfLastWord(s);
        System.out.println(
                length
        );
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int lengthOfLastWord2(String s) {
        int length = s.length();
        // 倒序遍历找到最后一个字母所在的位置
        while (length > 0 && s.charAt(length - 1) == ' ') {
            length--;
        }

        int result = 0;
        // 倒序遍历找到第一个空格为止， 就说明是最后一个单次的长度
        while (length > 0 && s.charAt(length - 1) != ' ') {
            length--;
            result++;
        }

        return result;
    }

    public int lengthOfLastWord1(@NotNull String s) {

        String[] s1 = s.split(" ");
        List<String> list = new ArrayList<>(s1.length);
        for (String s2 : s1) {
            if (!s2.isEmpty()) {
                list.add(s2);
            }
        }
        return list.get(list.size() - 1).length();
    }
}