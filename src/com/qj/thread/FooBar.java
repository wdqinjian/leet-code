package com.qj.thread;

/**
 * @author qinjian
 */
public class FooBar {

    private volatile boolean flag = true;

    private Object object;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object) {
                if (!flag) {
                    object.wait();
                }
                printFoo.run();
                flag = false;
                object.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (object) {
                if (flag) {
                    object.wait();
                }
                printBar.run();
                flag = true;
                object.notifyAll();
            }
        }
    }
}