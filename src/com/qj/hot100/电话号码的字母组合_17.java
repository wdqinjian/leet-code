package com.qj.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinjian
 */
public class 电话号码的字母组合_17 {

    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        电话号码的字母组合_17 demo = new 电话号码的字母组合_17();
        List<String> strings = demo.letterCombinations("23");
        strings.forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        int length = digits.length();
        if (length == 0) {
            return result;
        }
        dfs(digits, length, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String digits, int length, int index, List<String> result, StringBuilder sb) {

        if (length == index) {
            result.add(sb.toString());
        } else {
            // 当前下表的字符
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                dfs(digits, length, index + 1, result, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}