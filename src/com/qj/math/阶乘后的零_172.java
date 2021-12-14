package com.qj.math;

/**
 * @author qinjian
 */
public class 阶乘后的零_172 {

    public int trailingZeroes(int n) {

        // int res = 0;
        // long divisor = 5;
        // while (divisor <= n) {
        //     res += n / divisor;
        //     divisor *= 5;
        // }
        // return res;
        int res = 0;
        for (int d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }
}