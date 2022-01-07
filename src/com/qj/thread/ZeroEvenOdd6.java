package com.qj.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * 1116. 打印零与奇偶数
 * 现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
 * <p>
 * 例如，调用 printNumber(7) 将会输出 7 到控制台。
 * 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
 * <p>
 * 线程 A：调用 zero() ，只输出 0
 * 线程 B：调用 even() ，只输出偶数
 * 线程 C：调用 odd() ，只输出奇数
 * 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。
 * <p>
 * 实现 ZeroEvenOdd 类：
 * <p>
 * ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
 * void zero(printNumber) 调用 printNumber 以输出一个 0 。
 * void even(printNumber) 调用printNumber 以输出偶数。
 * void odd(printNumber) 调用 printNumber 以输出奇数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class ZeroEvenOdd6 {

    private int n;

    /**
     * 1、 0和2时， 打印 0
     * 2、 1时，  打印基数
     * 3、 3时，  打印偶数
     * <p>
     * 刚进来是0，打印0并自增为1
     * 是1了之后打印基数并自增为2
     * 是2了之后，再次打印0并自增为3
     * 是3了之后打印偶数，并回到初始值0
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public ZeroEvenOdd6(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (atomicInteger.get() != 0 && atomicInteger.get() != 2) {
                Thread.yield();
            }
            printNumber.accept(0);
            atomicInteger.incrementAndGet();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (atomicInteger.get() != 3) {
                Thread.yield();
            }
            printNumber.accept(i);
            atomicInteger.set(0);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {

            while (atomicInteger.get() != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            atomicInteger.incrementAndGet();
        }
    }

}