package com.qj.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author qinjian
 */
public class FooBar3 {
    private int n;

    private volatile Boolean flag = Boolean.TRUE;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public FooBar3(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

        FooBar3 fooBar = new FooBar3(10);//打印10次foo bar
        Runnable printFoo = () -> {
            System.out.printf("%s\n", "foo");
        };
        Runnable printBar = () -> {
            System.out.printf("%s\n", "bar");
        };
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        fooThread.start();
        barThread.start();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) {
                // flag 为FALSE 时， 空自旋
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = Boolean.FALSE;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            flag = Boolean.TRUE;
        }
    }
}