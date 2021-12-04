package com.qj;

/**
 * @author qinjian
 */
public class 整数反转_7 {


    public int reverse(int x) {

        int res = 0;
        while (x != 0) {

            // 取出个位上的数字
            int tmp = x % 10;

            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }

            // 加在之前数字的后面， 作为个位 54 * 10 + 3
            res = res * 10 + tmp;

            // 取整，最掉最后一位  如  1234 = 12345/10
            x = x / 10;
        }

        return res;
    }
}