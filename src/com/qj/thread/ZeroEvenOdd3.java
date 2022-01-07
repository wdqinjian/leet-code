package com.qj.thread;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @author qinjian
 */
public class ZeroEvenOdd3 {

    /**
     * 1、调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
     * public void await() throws InterruptedException { };
     * 2、和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
     * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
     * 3、将count值减1
     * public void countDown() { };
     */
    private CountDownLatch zeroLatch = new CountDownLatch(0);

    private CountDownLatch evenLatch = new CountDownLatch(1);

    private CountDownLatch oddLatch = new CountDownLatch(1);

    private int n;

    public ZeroEvenOdd3(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            zeroLatch.await();
            printNumber.accept(0);
            // 重置， 没法直接循环利用
            zeroLatch = new CountDownLatch(1);
            // 基数
            if ((i & 1) == 1) {
                // 减一 基数线程才能拿到锁
                oddLatch.countDown();
            } else {
                evenLatch.countDown();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            // 等待锁
            evenLatch.await();
            printNumber.accept(i);
            evenLatch = new CountDownLatch(1);
            zeroLatch.countDown();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            // 等待锁
            oddLatch.await();
            printNumber.accept(i);
            oddLatch = new CountDownLatch(1);
            zeroLatch.countDown();
        }
    }
}