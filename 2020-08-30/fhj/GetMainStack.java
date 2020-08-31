package code.Augus_30;

import java.util.Stack;

public class GetMainStack<T extends Comparable> {
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public GetMainStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public T push(T element) {
        dataStack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        } else {
            T min = minStack.peek();
            minStack.push(min.compareTo(element) < 0 ? min : element);
        }
        return element;
    }

    public T pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public T peek() {
        return dataStack.peek();
    }

    public boolean empty() {
        return dataStack.empty();
    }


    public T getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMainStack<Integer> getMainStack = new GetMainStack<>();
        getMainStack.push(5);
        getMainStack.push(5);
        getMainStack.push(4);
        getMainStack.push(5);
        getMainStack.push(5);
        getMainStack.push(3);
        getMainStack.push(5);
        //  5355455
        //  3344455
        while (!getMainStack.empty()) {
            System.out.println(getMainStack.getMin());
            getMainStack.pop();
        }
    }
}
