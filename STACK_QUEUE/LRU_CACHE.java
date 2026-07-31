/* 
*   PROBLEM STATEMENT ->
            Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

            Implement the LRUCache class: -

            LRUCache(int capacity): Initialize the LRU cache with positive size capacity.
            int get(int key): Return the value of the key if the key exists, otherwise return -1.
            void put(int key, int value): Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. 
            If the number of keys exceeds the capacity from this operation, evict the least recently used key.

            The functions get and put must each run in O(1) average time complexity.
------------------------------------------------------------------------------------------------------------------------------------------------------

!   NOTES & FULL EXPLANATION OF LRU CACHE     ->

*   NOTES DEFINITION ->
    "I use a HashMap and a Doubly Linked List. The HashMap stores key-to-node mappings so I can find a key in O(1). 
    The doubly linked list maintains the order of usage, with the least recently used node near the head and the most recently used node near the tail. 
    Whenever I access or insert a node, I move it to the MRU position. 
    When the cache exceeds capacity, I remove the node next to the head and delete its key from the HashMap. 
    This gives O(1) average time for both get and put, with O(capacity) space."

*   1. Introduction
    LRU stands for Least Recently Used. An LRU Cache is a cache with a fixed capacity.

*   It stores recently accessed data so that it can be retrieved quickly. When the cache becomes full and a new item needs to be inserted, 
*   then the item that is least recently used or not has been used for the longest time is removed.

-       For example, suppose the cache capacity is 3. If we perform:
        put(1, 100)
        put(2, 200)
        put(3, 300)

        the cache contains three items. Now suppose we call ->   get(1)
        Key 1 has just been used, so it becomes the most recently used item. 

        If we now execute ->  put(4, 400).... but , the cache is full. 
        Therefore, we remove key 3, assuming it is the least recently used.

*       The important point is that LRU is based on usage, not insertion time. Accessing an existing item changes its position in the cache.
        Make it recently used
-----------------------------------------------------------------------------------------------------------------------------------------------------

todo    2. What are we required to implement?

        An LRU Cache generally provides two operations:  get(key)  &&  put(key, value)

        1. get(key) -> should return the value associated with the key. If the key does not exist, it normally returns -1.
        2. put(key, value) ->  inserts a new key-value pair or updates an existing key.

        The important requirement is that both operations should work in O(1) average time. This requirement is what makes the problem interesting.
------------------------------------------------------------------------------------------------------------------------------------------------------

!   3. Why can't we use only one data structure?

    Suppose we use only a HashMap.
    A HashMap is excellent for finding a key quickly: key → value

    So get(key) can be approximately O(1).
    However, a HashMap does not directly solve our second problem :-->   which item is the least recently used?

    We need to maintain an ordering such as:
                                                LRU              MRU
                                                ↓                 ↓
                                                1  →  2  →  3  →  4
    where the leftmost item is the least recently used and the rightmost item is the most recently used.

    Now suppose we use only a normal list. We can maintain this ordering, but finding a particular key may require traversing the entire list, 
    resulting in O(n) search.
    Therefore, we combine two data structures.
------------------------------------------------------------------------------------------------------------------------------------------------------

*    4. Main idea: HashMap + Doubly Linked List

    The standard optimal solution uses:     HashMap + Doubly Linked List
    The HashMap is responsible for fast lookup, while the Doubly Linked List is responsible for maintaining the order of recent usage.

    The overall design is:

                    HashMap
                key → Node
                        │
                        ↓
    LRU ←→ Node ←→ Node ←→ Node ←→ MRU

    The HashMap lets us immediately locate the node corresponding to a key. Once we have the node, 
        the Doubly Linked List lets us remove it or move it to the most-recently-used position in O(1).

    This combination gives us the desired O(1) average time complexity.
------------------------------------------------------------------------------------------------------------------------------------------------------

!    5. Why a Doubly Linked List?

    This is one of the most important concepts in LRU Cache.
    Suppose our list is:    A ↔ B ↔ C

    Now imagine we access B. Since B has just been used, it needs to move to the MRU position:      A ↔ C ↔ B

    To do this efficiently, we first remove B from the middle:  and reconnect A and C:              A ↔ C
    And add it again at MRU..
    Because each node has both prev and next references, we can do this directly in O(1).

    Therefore, the doubly linked list is used because we need O(1) deletion and movement of nodes.
------------------------------------------------------------------------------------------------------------------------------------------------------

*   6. How do we maintain LRU and MRU?

    We maintain the list in this order:
*           HEAD → Least Recently Used
*           TAIL → Most Recently Used
    Usually, we create dummy head and dummy tail nodes to simplify the implementation.

    The actual structure looks like    ->
*           Dummy Head ↔ Node ↔ Node ↔ Node ↔ Dummy Tail

    The first actual node after head is the LRU.  The last actual node before tail is the MRU.
    So if the cache contains:   1 ↔ 2 ↔ 3   then:   1 = LRU  &&  3 = MRU

    When 1 is accessed  ->
    Before: 1 ↔ 2 ↔ 3                                   After:  2 ↔ 3 ↔ 1
                                                        Now 2 is LRU and 1 is MRU.
------------------------------------------------------------------------------------------------------------------------------------------------------

*   7. Working of get(key)

    Suppose the cache currently has:
        LRU    MRU
        ↓      ↓
        1 ↔ 2 ↔ 3

    and the HashMap contains:
                            1 → Node(1,100)
                            2 → Node(2,200)
                            3 → Node(3,300)

    Now we execute:     get(2);

    First, we use the HashMap to find node 2. This is O(1) average. The value is 200, so that is what we eventually return.
    But because 2 was just accessed, it must now become the most recently used item.

    Therefore, we remove it from its current position:  1 ↔ 2 ↔ 3   and insert it at the MRU side:  1 ↔ 3 ↔ 2
    So the complete process of get() is:

*   Find the node using HashMap → if it doesn't exist return -1 → remove it from its current position → add it at MRU → return its value.
------------------------------------------------------------------------------------------------------------------------------------------------------

*   8. Working of put(key, value)

    put() has two cases.

!   Case 1: Key already exists
    Suppose:    1 ↔ 2 ↔ 3   and we execute:     put(2, 500);    
    The value of key 2 changes from 200 to 500. Because we just used key 2, it also becomes MRU:    1 ↔ 3 ↔ 2

    So for an existing key, we: Find node → update value → remove node → move node to MRU.

!   Case 2: Key doesn't exist
    Suppose capacity is 3 and we currently have:    1 ↔ 2 ↔ 3
    Now:    put(4, 400);    The cache is already full, so we must remove the LRU item.

    Here:   1 = LRU     Therefore, remove 1 :->       2 ↔ 3
    and remove key 1 from the HashMap as well.

    Then create the new node:   2 ↔ 3 ↔ 4
    Now:    2 = LRU     4 = MRU

    This is the complete idea behind put().
------------------------------------------------------------------------------------------------------------------------------------------------------

*   9. Complete Dry Run

    Let's use:  Capacity = 3
    Initially:
            Cache = empty
            Operation 1
            put(1, 100);
    Cache:  1           1 is both LRU and MRU.

-   Operation 2:    put(2, 200);
    Cache:  1 ↔ 2       1 is LRU and 2 is MRU.

-   Operation 3:    put(3, 300);
    Cache:  1 ↔ 2 ↔ 3       Now 1 is LRU and 3 is MRU.

-   Operation 4:    get(1); We access 1, 
    so it becomes MRU: 2 ↔ 3 ↔ 1
    The returned value is:  100
    Now 2 is LRU.

-   Operation 5:    put(4, 400);    The cache is full.
    The LRU is 2, so remove it:     3 ↔ 1

-   Then insert 4 at MRU:   3 ↔ 1 ↔ 4
    Therefore:  get(2);     returns: -1 ,because 2 was evicted.

-   And:    get(3);
    returns: 300 ,  because 3 is still present.
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

package STACK_QUEUE;
import java.util.HashMap;

class LRUCache {

    class Node {
        int key;                            // Making key to also use it in HASHMAP
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node at MRU position                 Adding the node at the tail ...MRU is  tail side, LRU is head side            
    private void addNode(Node node) {

        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {        // Remove node from linked list

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {                   // To get key from hashmap

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);               // putting the key in newnode, making new node as key value

        removeNode(node);                       //* Recently used → move to MRU
        addNode(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {                 // Key already exists

            Node node = map.get(key);
            node.value = value;                     // Then only update its value

            removeNode(node);                       // Move to MRU
            addNode(node);

            return;     
        }
        // New key
        Node newNode = new Node(key, value);

        map.put(key, newNode);                      // else make new Node with key and value as itself
        addNode(newNode);                           // and add at the MRU

        if (map.size() > capacity) {                // *Capacity exceeded       
                                                    // IF capacity of LRU cache exceeds -> Then remove the least frequently used Node
            Node lru = head.next;                   // LRU is at head

            removeNode(lru);                        // REMOVE FROM BOTH , DLL & MAP
            map.remove(lru.key);
        }
    }
    public static void main(String[] args) {

        // Create LRU Cache with capacity 2
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1));  // 10

        cache.put(3, 30);

        System.out.println(cache.get(2));  // -1            // it is removed because capacity exceeded
        System.out.println(cache.get(3));  // 30
        System.out.println(cache.get(1));  // 10            // Becomes MRU

        cache.put(4, 40);

        System.out.println(cache.get(3));  // -             // it is removed because capacity exceeded
        System.out.println(cache.get(4));  // 40
    }
}
