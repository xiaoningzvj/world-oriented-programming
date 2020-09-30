package com.example.demo;

import java.util.Stack;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/23 8:50
 */
public class PalindromeNode {
    public static void main(String[] args) {
        System.out.print(123456);
    }

    public boolean palindromeNode(Node head) {
        if (head == null) {
            return true;
        }
        if (head.right == null) {
            return false;
        }
        Node top = head;
        Node current = head;
        Node next = current;
        //找中点
        while (next.right.right != null){
            next = next.right.right;
            current = current.right;
        }
        //  a  b  c  d  e  f  , current : c
        //  a  b  c  d  e     , current : c

        //方法一 翻转部分链表，但是改变了链表结构
        /*Node pre = current;
        Node right = null;
        Node mid = current.right;
        while (mid != null){
            right = mid.right;
            mid.right = pre;
            pre = mid;
            mid = right;
        }*/
        //方法二 采用栈存储数据，不改变链表结构，但是浪费了一点点空间
        Stack<Integer> stack = new Stack<>();
        current = current.right;
        while (current != null){
            stack.push(current.value);
        }
        //一一比对即可
        return true;
    }
}
