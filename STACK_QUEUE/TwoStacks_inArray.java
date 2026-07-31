/*               <<  You need to implement 2 stacks using a single array  >>

    Problem -> Stack 1 grows from left → right , Stack 2 grows from right → left        (Both should work independently.)

    EX ->    Array: [  _  _  _  _  _  _  ]  ->   Stack1 = grows from index 0 → 
                                                 Stack2 = grows from last index(n-1) ←

    IDEA ->          Maintain TWO pointers:
                        ->  top1 = -1 (start of array)
                        ->  top2 = n (end of array)

    OPERATIONS ->
                Push Stack 1:-    top1++  e.g, arr[top1] = value;               // to addd an value on top of stack1 (0 inndex wala)
                Push Stack 2:-    top2--  e.g, arr[top2] = value;               // -- because stack 2 is in reverse in array( n-1 index wala)

            << POP OPERATION  ARE REVERSE OF PUSH FOR EACH STACK 1 & STACK 2 >>

        Pop Stack 1:-     return arr[top1--];          // Simple and same as usual 
        Pop Stack 2:-     return arr[top2++];          // reverse(++) because the stack 2 is filling in reverse


    APPROACH & IDEA  ->>
                            Create one array
                            Maintain two ends
                            Let stacks grow toward each other
                            Stop when they collide

    WHY THIS WORKS ?     ->     Stack1 = left half  , Stack2 = right half
                                We allow dynamic space sharing
                                ✔ Better memory utilization
                                ✔ No wasted space

*/

package STACK_QUEUE ;
public class TwoStacks_inArray {
    int[] arr;
    int top1, top2;
    int size;

    public TwoStacks_inArray(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;              // starting from first index
        top2 = n;               // starting from last index
    }

    // Push Stack 1
    public void push1(int x) {

        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return;
        }
        top1 ++ ;
        arr[top1] = x;
    }

    // Push Stack 2
    public void push2(int x) {

        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow");
            return;
        }
        top2 -- ;
        arr[top2] = x;                    // in reverse
    }

    // Pop Stack 1
    public int pop1() {

        if (top1 < 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top1--];
    }

    // Pop Stack 2
    public int pop2() {

        if (top2 >= size) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top2++];
    }

    // PEEK Stack 1
    int peek1() {

        if (top1 == -1) {
            System.out.println("Stack 1 is empty");
            return -1;
        }

        return arr[top1];
    }

    // PEEK Stack 2
    int peek2() {

        if (top2 == arr.length) {
            System.out.println("Stack 2 is empty");
            return -1;
        }

        return arr[top2];
    }

     // Check Stack 1 empty
    boolean isEmpty1() {
        return top1 == -1;
    }

    // Check Stack 2 empty
    boolean isEmpty2() {
        return top2 == arr.length;
    }

    // Print Stack 1
    void printStack1() {

        System.out.print("Stack 1: ");

        for (int i = 0 ; i <= top1 ; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Print Stack 2
    void printStack2() {

        System.out.print("Stack 2: ");

        for (int i = arr.length - 1 ; i >= top2 ; i--) {            // Reverse
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        TwoStacks_inArray st = new TwoStacks_inArray(5);

        // Stack 1
        st.push1(10);
        st.push1(20);
        st.push1(30);

        // Stack 2
        st.push2(100);
        st.push2(200);
        st.push2(300);

        // Print
        st.printStack1();
        st.printStack2();

        // Peek
        System.out.println("Top of Stack 1: " + st.peek1());
        System.out.println("Top of Stack 2: " + st.peek2());

        // Pop
        System.out.println("Popped from Stack 1: " + st.pop1());
        System.out.println("Popped from Stack 2: " + st.pop2());

        // Print after pop
        st.printStack1();
        st.printStack2();

        // Empty check
        System.out.println("Is Stack 1 empty? " + st.isEmpty1());
        System.out.println("Is Stack 2 empty? " + st.isEmpty2());
    }
}