package com.qj.thread;

/**
 * @author qinjian
 */
public class FooBar2 {

    private int n;

    private volatile boolean flag = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (flag) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                // 需要执行n次， 满足了才自增
                i++;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (!flag) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printBar.run();
                flag = true;
                i++;
            } else {
                Thread.yield();
            }
        }
    }
}