package com.qj;

public class 斐波那契数_509 {

    public static void main(String[] args) {
        斐波那契数_509 demo = new 斐波那契数_509();
        int fib = demo.fib(30);
        System.out.println(" result : " + fib);
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
            System.out.println("  直接返回的 " + n);
            return memo[n];
        }
        // 完成递归调用
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);

        return memo[n];
    }

    public int fib1(int n) {

        if (n < 2) return n;

        // return fib(n-1) + fib(n-2);

        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }
}