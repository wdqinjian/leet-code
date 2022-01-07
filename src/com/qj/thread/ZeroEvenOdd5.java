package com.qj.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

public class ZeroEvenOdd5 {

    private int n;

    /**
     * 状态 0 - 打印0 1 - 打印基数 2 - 打印偶数
     */
    private int state;

    private Map<Integer, Thread> map = new ConcurrentHashMap<>(3, 1);

    public ZeroEvenOdd5(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        map.put(0, Thread.currentThread());
        for (int i = 1; i <= n; i++) {
            // 不是指定状态，等待
            while (state != 0) {
                LockSupport.park();
            }

            printNumber.accept(0);
            // 偶数
            if ((i & 1) == 0) {
                state = 2;
                LockSupport.unpark(map.get(2));
            } else {
                state = 1;
                LockSupport.unpark(map.get(1));
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        map.put(2, Thread.currentThread());
        for (int i = 2; i <= n; i += 2) {
            // 不是指定状态，等待
            while (state != 2) {
                LockSupport.park();
            }

            printNumber.accept(i);
            state = 0;
            LockSupport.unpark(map.get(0));
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        map.put(1, Thread.currentThread());
        for (int i = 1; i <= n; i += 2) {
            // 不是指定状态，等待
            while (state != 1) {
                LockSupport.park();
            }

            printNumber.accept(i);
            state = 0;
            LockSupport.unpark(map.get(0));
        }
    }
}