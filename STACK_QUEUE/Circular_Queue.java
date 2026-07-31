/* 
        What is a Circular Queue?
*       A Circular Queue is a queue in which the last position is logically connected to the first position.

        Instead of thinking:       0 → 1 → 2 → 3 → 4 → END

                        we think:
                                    0 → 1 → 2 → 3 → 4
                                    ↑                   ↓
                                    └───────────────────┘

                So after index 4, we can go back to index 0.

* Why Do We Need Circular Queue?
* Main reason:-  Efficiently reuse the empty spaces created after dequeue operations.

                In a normal array queue:    [ ][ ][ ][40][50]

                You might not be able to insert after rear reaches the last index.

                Circular queue allows:
                                        [60][70][ ][40][50]
                                        ↑
                                        rear wrapped around
                So the unused positions are reused.


*               Circular movement is achieved using:

*               (rear + 1) % capacity    &&     (front + 1) % capacity          (IMPORTANT FORMULAS)

                                    For example, capacity = 5:

                                    (0 + 1) % 5 = 1
                                    (1 + 1) % 5 = 2
                                    (2 + 1) % 5 = 3
                                    (3 + 1) % 5 = 4
                                    (4 + 1) % 5 = 0

                That's the magic behind circular queue.


!                What Problem Does a Normal Array Queue Have?

                        Suppose we have an array of size 5:

                        Index:   0   1   2   3   4
                                ┌───┬───┬───┬───┬───┐
                        Array:  │10 │20 │30 │40 │50 │
                                └───┴───┴───┴───┴───┘
                                   ↑               ↑
                                 FRONT            REAR

                Now remove three elements:
                                            dequeue()
                                            dequeue()
                                            dequeue()

        *               We get:

                        Index:    0   1   2   3   4
                                ┌───┬───┬───┬───┬───┐
                        Array:  │   │   │   │40 │50 │
                                └───┴───┴───┴───┴───┘
                                              ↑   ↑
                                            FRONT REAR

                    Notice:     index 0, 1, 2  are empty.

*       But if rear is already at index 4, a simple linear queue may say:  QUEUE IS FULL even though there is free space at the beginning!

!       This is called:     False Overflow

*---------------------------------------------  And Circular Queue solves this problem  --------------------------------------------------------------
 */

package STACK_QUEUE;

class CircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    CircularQueue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;                           // *while Enqueueing

        queue[rear] = value;
        size++;
    }

    int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queue[front];

        front = (front + 1) % capacity;                       // *while Dequeueing
        size--;

        return value;
    }

    int peek() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    boolean search(int value) {

        int index = front;

        for (int i = 0; i < size; i++) {

            if (queue[index] == value) {
                return true;
            }

            index = (index + 1) % queue.length;
        }

        return false;
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = 0 ; i < queue.length ; i++) {

            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.enqueue(60);
        q.enqueue(70);

        System.out.println(q.search(30) );

        q.display();

        System.out.println("Front: " + q.peek());
    }
}
