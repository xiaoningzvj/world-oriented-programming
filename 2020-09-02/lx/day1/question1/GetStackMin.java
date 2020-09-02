package com.example.demo.day1.question1;

import java.util.Comparator;
import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 *
 * 1.设计一个有getMin功能的栈
 *
 *  题目: 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *
 *  要求:  pop,push,getMin 操作的时间复杂度 为O（1）
 *        设计的栈类型可以使用现成的栈结构
 *
 * @date 2020.08.30
 **/
public class GetStackMin<E extends Comparable>{

    private Stack<E> stack1;

    private Stack<E> stack2;

    public GetStackMin() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public E push (E element) {
        E result;
        stack1.push(element);
        result = element;
        setStack2(element);

        return result;
    }

    private void setStack2(E element) {
        if (!stack2.empty()) {
            E min = stack2.pop();
            if (element.compareTo(min) <= 0)
                stack2.push(element);
            else
                stack2.push(min);

        } else
            stack2.push(element);
    }

    public E pop () {
        E result;
        result = stack1.pop();
        if (result.compareTo(stack2.peek()) == 0) {
            stack2.pop();
            Stack<E> temp = new Stack<>();
            while (!stack1.empty()) {
                E element = stack1.pop();
                setStack2(element);
                temp.push(element);
            }
            while (!temp.empty()) stack1.push(temp.pop());
        }
        return result;
    }

    public E getMin() {
        return stack2.peek();
    }
}
