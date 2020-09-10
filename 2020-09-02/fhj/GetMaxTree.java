package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GetMaxTree {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5};
        GetMaxTree getMaxTree = new GetMaxTree();
        Node head = getMaxTree.buildMaxTree(arr);
        //验证结果
        //层序遍历 看结果
        //todo
    }

    public Node buildMaxTree(int[] arr) {
        Node head = null;
        Map<Node, Node> leftMaxMap = new HashMap<>();
        Map<Node, Node> rightMaxMap = new HashMap<>();
        Node[] nodes = new Node[arr.length];
        Stack<Node> tempStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            Node current = new Node(arr[i]);
            nodes[i] = current;
        }
        for (Node current : nodes) {
            pushLeft(leftMaxMap, tempStack, current);
        }
        tempStack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            pushLeft(rightMaxMap, tempStack, nodes[i]);
        }
        //tempStack.clear();
        for (int i = 0; i < arr.length; i++) {
            Node current = nodes[i];
            //先查验左
            Node left = leftMaxMap.get(current);
            Node right = rightMaxMap.get(current);
            Node parent = null;
            if (left == null && right == null) {
                head = current;
                continue;
            }
            if (left == null && right != null) {
                parent = right;
            }
            if (left != null && right == null) {
                parent = left;
            }
            if (left != null && right != null) {
                parent = left.value < right.value ? left : right;
            }

            if (parent != null) {
                if (parent.left == null) {
                    parent.left = current;
                } else {
                    parent.right = current;
                }
            }
        }
        return head;
    }

    public void pushLeft(Map<Node, Node> leftMap, Stack<Node> stack, Node current) {
        if (stack.isEmpty()) {
            leftMap.put(current, null);
        }
        while (!stack.isEmpty() && stack.peek().value < current.value) {
            stack.pop();
        }
        if (stack.empty()) {
            leftMap.put(current, null);
        } else {
            leftMap.put(current, stack.peek());
        }
    }

}
