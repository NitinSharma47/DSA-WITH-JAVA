/*     
*                      Unlike the Previous code or the standard lemonade change problem  
    This code is used when the initial bill cost & denominations are not fixed as previous problem, 
    e.G, you dont have bill cost as 5$ OR the billcost can be anything, then the previous code become inefiicient and not useful..
    SO, Here is the generalized solution which you can use in any problem..

*   A generalized version where billcost is passed as a parameter, and the customer can pay with different bill denominations, 
    then you need to track all available denominations.

 */

import java.util.*;

public class Lemonade_Change_GeneralizedSolution{
    public static boolean change(int[] customer, int billcost) {

        Map<Integer, Integer> cash = new HashMap<>();
        for (int bill : customer) {

            if (bill == billcost) {                                             // Customer pays exact amount
                cash.put(bill, cash.getOrDefault(bill, 0) + 1);
                continue;
            }

            int required = bill - billcost;
            while (required > 0) {                                              // Try to make the required change

                int bestBill = -1;
                for (int denomination : cash.keySet()) {                        // Find the largest available bill <= required

                    if (denomination <= required &&
                        cash.get(denomination) > 0) {

                        if (denomination > bestBill) {
                            bestBill = denomination;
                        }
                    }
                }
                if (bestBill == -1) {                                            // Cannot make the required change
                    return false;
                }
                required -= bestBill;                                            // Give this bill as change
                cash.put(bestBill, cash.get(bestBill) - 1);
            }
            cash.put(bill, cash.getOrDefault(bill, 0) + 1);         // Keep customer's bill
        }
        return true;
    }

    public static void main(String[] args) {

        int[] customer = {5, 5, 10, 20};
        int billcost = 4;
        System.out.println(change(customer, billcost));
    }
}
