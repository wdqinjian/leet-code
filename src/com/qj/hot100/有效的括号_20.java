package com.qj.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @author qinjian
 */
public class 有效的括号_20 {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        // key - value
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 当前下表的元素
            char word = s.charAt(i);

            // 如果map 中有这个key,则说明是左括号
            // if ('(' == word || '[' == word || '{' == word) {
            if (map.containsKey(word)) {
                stack.push(word);
            } else {
                // 如果遇到右括号了，栈为空，则不是有效的
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                // 如果不是左括号，则弹出栈顶元素去匹配。 凑不出括号则不是有效的括号
                if (map.get(pop) != word) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}