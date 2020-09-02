package com.kning.demo;

import java.util.Stack;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/1
 **/
public class ReverseStack {
    public void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        // 获取第一个元素
        Integer fe = getFirstElement(stack);
        reverse(stack);
        stack.push(fe);
    }

    private Integer getFirstElement(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.empty()) {
            return pop;
        }
        Integer firstElement = getFirstElement(stack);
        stack.push(pop);

        return firstElement;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        new ReverseStack().reverse(stack);
        System.out.println(stack);
    }
}
