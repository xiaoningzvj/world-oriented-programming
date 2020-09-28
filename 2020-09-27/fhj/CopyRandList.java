package com.example.demo;


/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/28 10:59
 */
public class CopyRandList {
    public static void main(String[] args) {
        System.out.print(123456);
    }

    //第一种做法 map法 比较low 但好像 我瞬间就想到了 不写了
    //第二种做法
    public Node copy(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.right;
            Node copy = new Node(cur.value);
            copy.right = next;
            cur.right = copy;
            cur = next;
        }
        cur = head;
        Node rand = null;
        while (cur != null) {
            next = cur.right.right;
            rand = cur.right;
            rand.rand = cur.rand == null ? null : cur.rand.right;
            cur = next;
        }
        head = head.right;
        cur = head;
        while (cur != null) {
            cur.right = cur.right.right;
            cur = cur.right.right;
        }
        return head;
    }
}
