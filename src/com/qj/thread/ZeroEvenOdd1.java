package com.qj.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author qinjian
 */
public class ZeroEvenOdd1 {

    private int n;
    private Semaphore z = new Semaphore(1);
    // 基数
    private Semaphore e = new Semaphore(0);
    // 偶数
    private Semaphore o = new Semaphore(0);

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(5);

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
            z.acquire();
            printNumber.accept(0);
            // 奇数
            if ((i & 1) == 1) {
                o.release();
            } else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // 打印偶数
            if ((i & 1) == 0) {
                e.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            // 打印基数
            if ((i & 1) == 1) {
                o.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }
}