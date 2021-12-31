package com.qj.thread;

import java.util.concurrent.Semaphore;

/**
 * @author qinjian
 */
public class FooBar1 {

    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBar1(int n) {
        this.n = n;
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // 值为1的时候，能拿到，执行下面的操作
            fooSemaphore.acquire();
            printFoo.run();
            // 释放许可给barSemaphore这个信号量 barSemaphore 的值+1
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // 值为1的时候，能拿到，执行下面的操作
            barSemaphore.acquire();
            printBar.run();
            // 释放许可给 fooSemaphore 这个信号量 fooSemaphore 的值+1
            fooSemaphore.release();
        }
    }
}