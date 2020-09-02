package com.kning.demo;

import java.util.Stack;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/1
 **/
public class DoubleStackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(Integer element) {
        stack1.add(element);
    }

    public Integer pull() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        } else {
            return stack2.pop();
        }
    }

    public Integer peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        } else {
            return stack2.peek();
        }
    }
}
