package com.kning.demo;

import java.util.Stack;

/**
 * @author 王康宁
 * @version 1.0
 * @date 2020/9/9
 **/
public class MaximumBinaryTree {
    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            value = data;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for (int n : nums) {
            TreeNode node = new TreeNode(n);
            TreeNode pre = null;
            while (!stack.isEmpty() && stack.peek().value < n) {
                stack.peek().right = pre;
                pre = stack.pop();
            }
            node.left = pre;
            stack.push(node);
        }
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            stack.peek().right = pre;
            pre = stack.pop();
        }
        return pre;
    }
}
