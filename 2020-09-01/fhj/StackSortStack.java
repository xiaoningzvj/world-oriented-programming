package code.Augus_31;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Objects;
import java.util.Stack;

public class StackSortStack {
    private Integer currentMin = Integer.MAX_VALUE;
    private boolean flag = false;

    public Integer getMinElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return currentMin;
        }
        Integer ele = stack.pop();
        if (ele < currentMin) {
            currentMin = ele;
        }
        getMinElement(stack);
        if (Objects.equals(ele, currentMin)) {
            if (flag) {
                stack.push(ele);
            }
            flag = true;
        } else {
            stack.push(ele);
        }
        return currentMin;
    }

    public Stack sort(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(getMinElement(stack));
            currentMin = Integer.MAX_VALUE;
            flag = false;
        }
        return result;
    }

    public static void main(String[] args) {
        StackSortStack stackSortStack = new StackSortStack();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(3);

        Stack<Integer> result = stackSortStack.sort(stack);
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }
}
