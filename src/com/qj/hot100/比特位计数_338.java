package com.qj.hot100;

/**
 * @author qinjian
 */
public class 比特位计数_338 {

    public int[] countBits(int n) {

        int[] result = new int[n + 1];
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            // 如果是基数， 一定是比自己前面的数多一个1，  如 2-》10   3-》11
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
            } else {
                // 偶数中 1 的个数一定和除以 2 之后的那个数一样多,
                // 最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉  4 = 100       8 = 1000
                result[i] = result[i / 2];
            }
        }

        return result;
    }
}