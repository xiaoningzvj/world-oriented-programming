package code.Augus_30;

import java.util.Queue;
import java.util.Stack;

public class TwoStackQueue<T> {
    private Stack<T> mainStack;
    private Stack<T> assStack;

    public TwoStackQueue() {
        mainStack = new Stack<>();
        assStack = new Stack<>();
    }

    public boolean add(T element) {
        if (!mainStack.empty()) {
            while (!mainStack.empty()) {
                assStack.push(mainStack.pop());
            }
        }
        assStack.push(element);
        while (!assStack.empty()) {
            mainStack.push(assStack.pop());
        }
        return true;
    }

    public T poll() {
        return mainStack.pop();
    }

    public T peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.empty();
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> twoStackQueue = new TwoStackQueue<>();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        //1
        System.out.println(twoStackQueue.poll());
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        twoStackQueue.add(5);
        //2345
        while (!twoStackQueue.empty()) {
            System.out.println(twoStackQueue.poll());
        }
    }
}
