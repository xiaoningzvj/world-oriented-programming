package com.kning.demo;

import java.util.Stack;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/1
 **/
public class GetMainStack {

    // 数据栈
    private Stack<Integer> baseStack = new Stack<>();
    // 记录栈
    private Stack<Integer> recordStack = new Stack<>();

    public void push(int item) {
        baseStack.push(item);

        if (recordStack.empty() || item < recordStack.peek()) {
            recordStack.push(item);
        } else {
            recordStack.push(recordStack.peek());
        }
    }

    public void pop() {
        recordStack.pop();
        baseStack.pop();
    }

    public int top() {
        return baseStack.peek();
    }

    public int min() {
        return recordStack.peek();
    }
}
