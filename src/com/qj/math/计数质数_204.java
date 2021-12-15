package com.qj.math;

import java.util.Arrays;

/**
 * @author qinjian
 */
public class 计数质数_204 {

    public static void main(String[] args) {
        计数质数_204 solution = new 计数质数_204();
        System.out.println(solution.countPrimes(10));
    }

    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public int countPrimes1(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            // 在大于 1 的自然数中，除了 11 和它本身以外不再有其他因数的自然数。
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}