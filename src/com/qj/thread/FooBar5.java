package com.qj.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author qinjian
 */
public class FooBar5 {

    private int n;

    private BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<>(1);

    {
        {
            // 给fooQueue 添加元素，保证先执行
            fooQueue.add(0);
        }
    }

    public FooBar5(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // 拿不到会阻塞
            fooQueue.take();
            printFoo.run();
            // 给另外一个添加元素
            barQueue.put(0);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.put(0);
        }
    }


}