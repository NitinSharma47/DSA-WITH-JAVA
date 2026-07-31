package STACK_QUEUE;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingOneQueue {

    Queue<Integer> q = new LinkedList<>();

    // PUSH
    void push(int value) {

        q.offer(value);

        // Move all previous elements behind the new element to main stack behaviour
        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    // POP
    int pop() {

        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q.poll();
    }

    // PEEK
    int peek() {

        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q.peek();
    }

    // ISEMPTY
    boolean isEmpty() {
        return q.isEmpty();
    }

    // SIZE
    int size() {
        return q.size();
    }

    // PRINT
    void printStack() {
        System.out.println(q);
    }

    public static void main(String[] args) {

        StackUsingOneQueue stack = new StackUsingOneQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack:");
        stack.printStack();

        System.out.println("Top: " + stack.peek());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Popped: " + stack.pop());

        System.out.println("Stack after pop:");
        stack.printStack();

        System.out.println("Size: " + stack.size());

        System.out.println("Is empty? " + stack.isEmpty());
    }
}
