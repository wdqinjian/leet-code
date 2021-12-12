package com.qj.math;

public class 位1的个数_191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // 利用 &运算消除1
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}