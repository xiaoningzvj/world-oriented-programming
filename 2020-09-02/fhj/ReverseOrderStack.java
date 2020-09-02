package code.Augus_30;

import java.util.Stack;

public class ReverseOrderStack<T> {

    private Stack<T> assStack;

    public ReverseOrderStack() {
        assStack = new Stack<>();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        ReverseOrderStack<Integer> reverseOrderStack = new ReverseOrderStack();
        reverseOrderStack.order(stack);
        //12345
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public T removeFirst(Stack<T> stack) {
        //获取当前层数据
        T res = stack.pop();
        if (stack.empty()) {
            return res;
        }
        //压递归栈
        //保留最后一层数据
        T last = removeFirst(stack);
        //压当前层数据
        stack.push(res);
        //返回底层数据
        return last;
    }

    public void order(Stack<T> stack) {
        if (stack.empty()) {
            return;
        }
        //拿到当成数据
        T first = removeFirst(stack);
        //压递归栈
        order(stack);
        //压这一层的数据
        stack.push(first);
        return;
    }
}
