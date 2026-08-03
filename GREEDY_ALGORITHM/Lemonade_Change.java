/* 
Given an array representing a queue of customers and the value of bills they hold, determine if it is possible to provide correct change to each customer.
Customers can only pay with 5$, 10$ or 20$ bills and we initially do not have any change at hand. 
Return true, if it is possible to provide correct change for each customer otherwise return false.

*   The Bill costs 5$ for each person..
*/

class LemonadeStand {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;                                       // Counter for $5 bills
        int ten = 0;                                        // Counter for $10 bills

        for (int bill : bills) {                            // Process each customer's bill
            if (bill == 5) {
                five++;                                     // Accept $5 (no change needed)
            } 
            else if (bill == 10) {
                if (five > 0) {                             // *And we have changes of 5
                    five--;                                 // Give one $5 as change        
                    ten++;                                  // Accept $10
                } 
                else {
                    return false;                           // *Cannot give change , when does not 5 $ denominations
                }
            } 
            else {                                      // if bill == 20
                if (five > 0 && ten > 0) {              // & have five and ten $ denominations
                    five--;                             // Use one $5
                    ten--;                              // Use one $10
                } 
                else if (five >= 3) {                   // *Another method to pay change of 15 ( 5,5,5)
                    five -= 3;                          // Use three $5 bills
                } 
                else {
                    return false;                       // Cannot give change
                }
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};

        System.out.print("Queue of customers: ");
        for (int bill : bills) System.out.print(bill + " ");
        System.out.println();

        LemonadeStand stand = new LemonadeStand();
        boolean ans = stand.lemonadeChange(bills);

        if (ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}

