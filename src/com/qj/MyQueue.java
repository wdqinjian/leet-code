package com.qj;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * @author qinjian
 */
public class MyQueue {

    private Deque<Integer> out = null;
    private Deque<Integer> in = null;

    public MyQueue() {
        in = new ArrayDeque<Integer>();
        out = new ArrayDeque<Integer>();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
    }

    public void push(int x) {
        in.push(x);
    }

    /**
     * 除队头的元素并返回
     *
     * @return
     */
    public int pop() {
        checkOutStack();
        return out.pop();
    }

    public int peek() {
        checkOutStack();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void checkOutStack() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */