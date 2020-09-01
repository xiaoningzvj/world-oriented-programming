package com.example.demo.day2.question1;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 *
 * 一个栈中元素的类型为整形，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈，
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构，如何完成排序
 *
 * @date 2020.08.31
 **/
public class SortedStack<E extends Comparable> {

    private Stack<E> stack;

    public SortedStack() {
        stack = new Stack<>();
    }

    public Stack<E> sortedStack(Stack<E> input) {
        while (!input.empty()) {
            E element = input.pop();
            if (stack.empty()) {
                stack.push(element);
                continue;
            }
            E peek = stack.peek();
            if (element.compareTo(peek) >= 0) stack.push(element);
            else {
                setStackElement(stack,element);
            }
        }
        return stack;
    }

    private void setStackElement(Stack<E> stack, E element) {
        if (stack.empty()) return;
        E peek = stack.peek();
        if (element.compareTo(peek) >= 0) {
            stack.push(element);
            return;
        }
        E pop = stack.pop();
        setStackElement(stack,element);
        stack.push(pop);
    }
}
