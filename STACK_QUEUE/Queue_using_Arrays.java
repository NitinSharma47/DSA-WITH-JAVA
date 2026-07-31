/* 
                         A Queue is a linear data structure that follows the principle: 
                                    *  FIFO — First In, First Out

*                           This means the element that enters the queue first is removed first.

                            A queue has two important ends:

*                           FRONT ->    The front is where we remove/delete elements.
*                           REAR  ->    The rear is where we insert/add elements.

*                                            Queue
*                                ┌────┬────┬────┬────┐
*                                │ 10 │ 20 │ 30 │ 40 │
*                                └────┴────┴────┴────┘
*                                   ↑              ↑
*                                 FRONT           REAR

!  In java 's Interface ->   
*                           Enqueue  =  Offer
*                           Dequeue  =  Poll


                So:  Insertion → REAR    &&     Deletion  → FRONT

*                    Enqueue → Rear    &&    Dequeue → Front

                Enqueue means inserting an element into the queue.
                Dequeue means removing an element from the queue.
                peek() returns the element at the front without removing it.

------------------------------------------------------------------------------------------------------------------------------------------------------

*       Problem With Simple Array Queue

There's an important problem with the above implementation.

                Suppose capacity = 5:

                [10][20][30][40][50]
                ↑                 ↑
                front             rear

                Now dequeue three times:

                dequeue() → 10
                dequeue() → 20
                dequeue() → 30

*               We logically have:

!               [ ][ ][ ][40][50]
                        ↑     ↑
                        front  rear

*               There are two empty spaces at the beginning , But rear is already at the last index.

                So a new enqueue() might report:
!               Queue is full, even though there is free space.

*               This is called ** wasted space  **

                                        That's why we have the:

*                          ------------     Circular Queue     --------------



*/

package STACK_QUEUE;

class Queue {               //** Queue will always contains the elements between front & rear..**

    int queue[] ;
    int front ;
    int rear ;
    int size ;          // * This variable is tracking/counting the length of the queue

    Queue(int capacity ){                       // capacity is the length of queue ... we make
        queue = new int[capacity] ;
        front = 0 ;
        rear = -1 ;
        size = 0 ;              // current size of queue

    }

    void enqueue(int value){
        

        if (size == queue.length){
            System.out.println("queue is full! can't enqueue");
            return;
        }
        rear ++ ;           // when adding first element , rear becomes 0 from -1
        queue[rear] = value ;
        size ++ ;                   // Trace the length of the queue

    }

    int dequeue (){
        if(size == 0 ){
            System.out.println("Cant't  Dequeue");
            return -1;
        }
        int value = queue[front] ;                      // store the current value of front in value
        front ++ ;                                      // Move front forward
        size -- ;                                       // decrease the size as one element from queue is removed 

        return value ;
    }

    int peek(){

        if(size == 0){
            System.out.println("Nothing to peek!!");
            return -1 ;
        }
        
        return queue[front] ;
    }

    boolean isEmpty(){
        return size == 0 ;
    }

    boolean search(int value){
        int temp = front ;

        while(temp <= rear){
            if(queue[temp] == value){
                return true ;
            }

            temp ++ ;
        }
        return false ;
    }

    void printq(){

        for(int curr = front ; curr < queue.length ; curr ++){       //* searching will also startts from front, otherwise it also contains
                                                                    //*  the elements which are dequeued fromm queue
            System.out.println(queue[curr]);
        }
        System.out.println();
    }

    

    public static void main(String[] args) {
        Queue q = new Queue(5) ;

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(7);
        q.enqueue(10);

        q.printq();

        q.dequeue();
        q.dequeue();

        q.printq();

        q.peek();

        System.out.println("Search 2: " + q.search(2));
        System.out.println("Search 10: " + q.search(10));

        System.out.println("Is queue empty? " + q.isEmpty());

        q.printq();

    }
}
