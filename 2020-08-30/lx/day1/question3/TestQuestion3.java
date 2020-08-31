package com.example.demo.day1.question3;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.08.30
 **/
public class TestQuestion3 {
    public static void main(String[] args) {
        ReverseStack<Integer> reverseStack = new ReverseStack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Stack<Integer> stack1 = reverseStack.reverseStack(stack);
        while (!stack1.empty()) System.out.println(stack1.pop());
    }
}
