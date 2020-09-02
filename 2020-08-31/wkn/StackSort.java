package com.kning.demo;

import sun.invoke.empty.Empty;

import java.util.Date;
import java.util.Stack;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/1
 **/
public class StackSort {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void sort(Stack<Integer> stack) {
    }

    public void push(Integer item) {
        if (!stack.empty() && item < stack.peek()) {
            while (!stack.empty() && item < stack.peek()) {
                help.push(stack.pop());
            }
            stack.push(item);
            while (!help.empty()) {
                stack.push(help.pop());
            }
            return;
        }
        stack.push(item);
    }

    public void pop() {
        if (!stack.empty()) {
            stack.pop();
        }
    }

    public Integer peek() {
        if (!stack.empty()) {
            return stack.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        StackSort stack = new StackSort();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.stack.toString());

    }
}
