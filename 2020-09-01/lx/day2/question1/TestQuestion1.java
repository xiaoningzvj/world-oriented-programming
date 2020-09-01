package com.example.demo.day2.question1;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 * @date 2020.08.31
 **/
public class TestQuestion1 {
    public static void main(String[] args) {
        SortedStack<Integer> sortedStack = new SortedStack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        Stack<Integer> stack1 = sortedStack.sortedStack(stack);

        while (!stack1.empty()) System.out.println(stack1.pop());
    }
}
