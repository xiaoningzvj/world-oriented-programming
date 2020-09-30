package com.example.demo;

/**
 * @author fanhongjiang
 * @version 1.0
 * @date 2020/9/15 8:44
 */
public class RevertNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        RevertNode revertNode = new RevertNode();
        node1 = revertNode.revert(node1);
        Node cur = node1;
        while (cur.right != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.print(cur.value);
    }


    public Node revert(Node head) {
        if (head == null) {
            return null;
        }
        if (head.right == null) {
            return head;
        }
        Node last = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.right;
            current.right = last;
            last = current;
            current = next;
        }
        return last;
    }


    /*public Node revertPart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fpre = null;
        Node tpos = null;
        while (node1 != null) {
            len++;
            if (len == from - 1) {
                fpre = node1;
            }
            if (len == to + 1) {
                tpos = node1;
            }
            node1 = node1.right;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        //获取from节点
        node1 = fpre == null ? head : fpre.right;
        //获取from +1 节点
        Node node2 = node1.right;
        //from节点 连上 尾巴节点（null or to +1)
        node1.right = tpos;
        Node next = null;
        while (node2 != tpos) {
            next = node2.right;
            node2.right = node1;
            node1 = node2;
            node2 = next;
        }
        if (fpre != null) {
            fpre.right = node1;
            return head;
        }
        return node1;
    }*/

    public Node revertPart(Node head, int from, int to) {
        if (head == null || head.right == null) {
            return head;
        }
        Node node1 = head;
        int index = 0;
        Node top = null;
        Node bottom = null;
        // A     B   C   D   E      F    G
        //      from        to     to+1
        // A ->  E - > D -> C -> B -> F -> G
        //
        while (node1 != null) {
            index++;
            top = index == from - 1 ? node1 : null;
            bottom = index == to + 1 ? node1 : null;
            node1 = node1.right;
        }
        if (from < 1 || to < from || index < to) {
            return head;
        }
        node1 = top == null ? head : top.right;
        Node node2 = node1.right;
        node1.right = bottom;
        Node next = null;
        while (node2 != bottom) {
            next = node2.right;
            node2.right = node1;
            node1 = node2;
            node2 = next;
        }
        if (top == null) {
            return node1;
        } else {
            top.right = node1;
            return head;
        }
    }
}
