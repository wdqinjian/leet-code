package com.qj;

public class 最长回文子串_5 {

    public static void main(String[] args) {
        最长回文子串_5 demo = new 最长回文子串_5();

        String s = "babad";
        System.out.println(demo.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        String res = "";
        for (int i = 0; i < length; i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }

        return res;
    }

    private String palindrome(String s, int left, int right) {
        // 判断， 防止越界
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(left + 1, right);
    }

}