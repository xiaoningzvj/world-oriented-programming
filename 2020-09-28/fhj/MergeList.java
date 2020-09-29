package com.example.demo;

import java.util.Stack;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/29 8:57
 */
public class MergeList {
    public static void main(String[] args) {
        System.out.print(123456);
    }

    //首先想到
    //1.获得两个字符串，相加，在重新赋值新链表？？这么做虽然简单 但是占用了空间
    //缺陷：数字过大的时候，无法用int表示，做和
    //2.
    public Node mergeList(Node head1, Node head2) {
        Stack<Integer> stackleft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        while (head1 != null) {
            stackleft.push(head1.value);
            head1 = head1.right;
        }
        while (head2 != null) {
            stackRight.push(head2.value);
            head2 = head2.right;
        }
        int left = 0;
        int right = 0;
        int value = 0;
        int curVal = 0;
        int cal = 0;
        Node last = null;
        while (!stackleft.isEmpty() || !stackRight.isEmpty()) {
            left = stackleft.isEmpty() ? 0 : stackleft.pop();
            right = stackRight.isEmpty() ? 0 : stackRight.pop();
            value = left + right + cal;
            cal = 0;
            if (value > 9) {
                curVal = value / 10;
                cal = 1;
            } else {
                curVal = value;
            }
            Node node = new Node(curVal);
            node.right = last;
            last = node;
        }
        return last;
    }
}
