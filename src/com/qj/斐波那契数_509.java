package com.qj;

public class 斐波那契数_509 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        斐波那契数_509 demo = new 斐波那契数_509();
        int fib = demo.fib(100);
        System.out.println(" 耗时 : " + (System.currentTimeMillis() - start));
        System.out.println(" result : " + fib);

        long start1 = System.currentTimeMillis();
        int fib1 = demo.fib1(100);
        System.out.println(" 耗时 : " + (System.currentTimeMillis() - start1));
        System.out.println(" result : " + fib1);

        long start2 = System.currentTimeMillis();
        int fib2 = demo.fib2(80);
        System.out.println(" 耗时 : " + (System.currentTimeMillis() - start2));
        System.out.println(" result : " + fib2);
    }

    public int fib(int n) {
        //if(n < 2) return n;
        // return fib(n-1) + fib(n-2);

        // 备忘录全初始化为 0
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        if (n < 2) {
            return n;
        }

        if (0 != memo[n]) {
            // System.out.println("  直接返回的 " + n);
            return memo[n];
        }
        // 完成递归调用
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);

        return memo[n];
    }

    public int fib1(int n) {

        if (n < 2) {
            return n;
        }

        // return fib(n-1) + fib(n-2);

        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }


    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }
}