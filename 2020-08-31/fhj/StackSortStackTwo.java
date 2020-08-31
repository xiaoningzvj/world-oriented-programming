package code.Augus_31;

import java.util.Stack;

public class StackSortStackTwo {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            while (!help.isEmpty()) {
                if (curr > help.peek()) {
                    stack.push(help.pop());
                }else {
                    break;
                }
            }
            help.push(curr);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
