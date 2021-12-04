package com.qj;

public class 回文数_9 {


    public boolean isPalindrome(int x) {

        /**
         * 1、负数一定不是回文数
         * 2、如果末尾为0的非0数一定不是回文数。
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int tmep = x;
        int cur = 0;
        while (tmep > 0) {
            cur = cur * 10 + tmep % 10;
            // 逐步去掉末位
            tmep /= 10;
        }

        return cur == x;
    }

    public boolean isPalindrome2(int x) {
        // 利用现成的java API
        String reversedStr =
                (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

}