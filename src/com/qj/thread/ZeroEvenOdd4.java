package com.qj.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

/**
 * @author qinjian
 */
public class ZeroEvenOdd4 {


    private int n;

    private volatile Boolean flag = Boolean.TRUE;
    private CyclicBarrier evenCyclic = new CyclicBarrier(2);
    private CyclicBarrier oddCyclic = new CyclicBarrier(2);

    public ZeroEvenOdd4(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (!flag) {

            }
            printNumber.accept(0);
            flag = Boolean.FALSE;
            try {
                // 基数
                if ((i & 1) == 1) {
                    // 减一 基数线程才能拿到锁
                    oddCyclic.await();
                } else {
                    evenCyclic.await();
                }
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            try {
                // 等待锁
                evenCyclic.await();
                printNumber.accept(i);
                flag = Boolean.TRUE;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            try {
                // 等待锁
                oddCyclic.await();
                printNumber.accept(i);
                flag = Boolean.TRUE;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}