package com.example.demo.day1.question3;

import java.util.Stack;

/**
 * @author liangxin
 * @classname
 * @description
 *
 * 3.如何仅用递归函数和栈操作逆序一个栈
 *
 * 题目： 一个栈依次压入 1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，
 * 但是只能用递归函数实现，不能用其他数据结构
 *
 * @date 2020.08.30
 **/
public class ReverseStack<E> {

    public Stack<E> reverseStack (Stack<E> stack) {
        if (stack.empty()) return stack;
        return reverseStack(stack,null);
    }


    private Stack<E> reverseStack (Stack<E> stack,Stack<E> temp) {
       if (temp == null) temp = new Stack<>();
       temp.push(stack.pop());
       if (!stack.empty()) {
           reverseStack(stack,temp);
       }
       return temp;
    }


}
