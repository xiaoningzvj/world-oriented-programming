package com.example.demo.day1.question2;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 *
 * 2.两个栈组成的队列
 *
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作（add,poll,peek）
 *
 * 队列先进先出
 *
 * @date 20202.08.31
 **/
public class ImitateTheQueue<E> {

    private Stack<E> stack1;

    private Stack<E> stack2;

    public ImitateTheQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 1,2,3
    public E add(E element) {
        stack1.push(element);
        return element;
    }

    public E poll() {

        while (!stack1.empty())
            stack2.push(stack1.pop());
        E result = stack2.pop();
        while (!stack2.empty())
            stack1.push(stack2.pop());
        return result;
    }

    public E peek() {
        while (!stack1.empty())
            stack2.push(stack1.pop());
        E result = stack2.peek();
        while (!stack2.empty())
            stack1.push(stack2.pop());
        return result;
    }

}
