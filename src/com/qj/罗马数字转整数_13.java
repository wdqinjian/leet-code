package com.qj;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinjian
 */
public class 罗马数字转整数_13 {

    private static Map<Character, Integer> map = null;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


    }

    public static void main(String[] args) {
        罗马数字转整数_13 demo = new 罗马数字转整数_13();
        String s = "IVII";
        int i = demo.romanToInt(s);
        System.out.println(i);


    }

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = map.get(s.charAt(i));
            // 如果当前不是最后一个字符， 并且在之后的一个字符对应的值比当前的要大， 说明当前的是需要被减掉的，  例如 IV  ->   -1 + 5 = 4;
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}