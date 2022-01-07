package com.qj.thread;

import java.util.function.IntConsumer;

/**
 * @author qinjian
 */
public class ZeroEvenOdd2 {

    private int n;

    private int state;

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(5);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (state != 0) {
                Thread.yield();
            }
            printNumber.accept(0);

            // 基数
            if ((i & 1) == 1) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    /**
     * 输出偶数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }

    /**
     * 输出基数
     *
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }
}