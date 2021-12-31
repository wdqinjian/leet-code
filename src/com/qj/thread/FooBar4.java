package com.qj.thread;

import java.util.concurrent.locks.ReentrantLock;

public class FooBar4 {

    private int n;

    private volatile Boolean falg = true;

    private ReentrantLock lock = new ReentrantLock(true);

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (falg) {
                    printFoo.run();
                    falg = false;
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!falg) {
                    printBar.run();
                    falg = true;
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}