package STACK_QUEUE;

import java.util.Stack;

class QueueUsingOneStack {

    Stack<Integer> s = new Stack<>();

    // ENQUEUE
    void enqueue(int value) {
        s.push(value);
    }

    // DEQUEUE
    int dequeue() {

        if (s.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Remove top element
        int top = s.pop();

        // If this is the last/bottom element
        if (s.isEmpty()) {
            return top;
        }

        // Recursively remove bottom element
        int result = dequeue();

        // Put the removed elements back
        s.push(top);

        return result;
    }

    // PEEK
    int peek() {

        if (s.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int top = s.pop();

        if (s.isEmpty()) {

            // Put it back
            s.push(top);

            return top;
        }

        int result = peek();

        // Restore stack
        s.push(top);

        return result;
    }

    // ISEMPTY
    boolean isEmpty() {
        return s.isEmpty();
    }

    // SIZE
    int size() {
        return s.size();
    }

    // PRINT
    void printQueue() {
        System.out.println(s);
    }

    public static void main(String[] args) {

        QueueUsingOneStack q = new QueueUsingOneStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("Queue:");
        q.printQueue();

        System.out.println("Front: " + q.peek());

        System.out.println("Removed: " + q.dequeue());

        System.out.println("Removed: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.printQueue();

        System.out.println("Front: " + q.peek());

        System.out.println("Size: " + q.size());

        System.out.println("Is empty? " + q.isEmpty());
    }
}