// *                    FORMULA =>   Minimum moves = 2ⁿ - 1

/*              The Tower of Hanoi is one of the most famous recursion problems.

                We have:

                3 rods: Source, Auxiliary, Destination
                N disks of different sizes
                Initially, all disks are on the Source rod.

            *   The goal is to move all disks to the destination rod.

            *   Rules
                Only one disk can be moved at a time.
                You can move only the top disk.
                A larger disk cannot be placed on a smaller disk.
 */
public class Tower_of_Hanoi {
    static void towerOfHanoi(int n, char source, char helper, char destination) {

        if (n == 0) {       // Base case
            return;
        }
        
        towerOfHanoi(n - 1, source, destination, helper );       // Step 1: Move n-1 disks from source to auxiliary

        System.out.println("Move disk " + n + " from " + source + " to " + destination );       // Step 2: Move the largest disk to destination

        towerOfHanoi(n - 1, helper, source, destination );               // Step 3: Move n-1 disks from auxiliary to destination
    }
    public static void main(String[] args) {

        int n = 3;
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}