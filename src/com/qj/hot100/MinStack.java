package com.qj.hot100;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author qinjian
 */
public class MinStack {

    private Stack<Integer> stack = null;
    private int minVal;

    public MinStack() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
//        ["MinStack","push","push","push","getMin","pop","top","getMin"]
//        [[],[-2],[0],[-3],[],[],[],[]]

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        minStack.top();
        min = minStack.getMin();
        System.out.println(min);

//        ["MinStack","push","push","push","getMin","top","pop","getMin"]
//        [[],[-2],[0],[-1],[],[],[],[]]

//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-1);
//        int min = minStack.getMin();
//        System.out.println(min);
//        minStack.top();
//        minStack.pop();
//        min = minStack.getMin();
//        System.out.println(min);

//        ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minVal = val;
        }
        stack.push(val);
        setMinVal();
    }

    public void pop() {
        Integer pop = stack.pop();

        if (stack.isEmpty()) {
            minVal = 0;
            return;
        }

        if (pop == minVal) {
            minVal = stack.peek();
            setMinVal();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVal;
    }

    private void setMinVal() {
        for (Integer val : stack) {
            if (val < minVal) {
                minVal = val;
            }
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */