package com.qj.math;

/**
 * @author qinjian
 */
public class TWO的幂_231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}