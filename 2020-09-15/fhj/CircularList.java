package com.example.demo;


/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/17 10:01
 */
public class CircularList {
    public static void main(String[] args){
        System.out.print(123456);
    }

    public Node getLastOne(Node head, int m) {
        if (head == null || head.right == null || m == 1) {
            return null;
        }
        Node pre = null;
        Node current = head;
        int index = 0;
        while (current.right != current) {
            index++;
            if (index == m) {
                index = 0;
                pre.right = current.right;
                current = pre.right;
                continue;
            }
            pre = current;
            current = current.right;
        }
        return current;
    }


    public Node getLastNode(Node head, int m) {
        if (head == null || head.right == null || m < 1) {
            return head;
        }
        Node last = head;
        //找到head的上一个节点
        while (last.right != head) {
            last = last.right;
        }
        int count = 0;
        while (head != last) {
            if(++count == m ){
                //删除当前节点
                last.right = head.right;
                count = 0;
            }else {
                last = last.right;
            }
            head = head.right;
        }
        return head;
    }

    /*public Node getLastTwo(Node head, int m) {

    }*/
}