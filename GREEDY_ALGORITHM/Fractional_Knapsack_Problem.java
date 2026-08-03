/*  
        The weight of N items and their corresponding values are given. 
        We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

*       Note: We can either take the item as a whole or break it into smaller units.

        Input:  val = [60, 100, 120], wt = [10, 20, 30], capacity = 50  
        Output:     240.000000  
        Explanation: 
                - Take item 0 (w = 10, v = 60)  
                - Take item 1 (w = 20, v = 100)  
                - Take 2⁄3 of item 2 (w = 20, v = 80)  
                Total value = 60 + 100 + 80 = 240

*      The Greedy Strategy: Maximum Value Per Weight Ratio
        Since we can break items into arbitrary fractions, the optimal decision at every step is to pick items that give 
        us the highest value per unit of weight.

    *   Step-by-Step Algorithm
    -   Calculate Value-to-Weight Ratio: For every item i, calculate its density or efficiency: Ratio[i] = Value[i] / Weight[i]
    -   Sort Items: Sort all items in descending order based on their ratio (Ratio[i])
    -   Iteratively Fill the Knapsack: Loop through the sorted items and keep track of remaining capacity:
            Case A: Item fits completely -> Add the item's full value to total value.   ->  Subtract item's weight from the remaining capacity.
            Case B: Item cannot fit completely ->   Take a fraction of the item , which can fit to knapsack(capacity)
                Add value of i , equal to fraction
        Set remaining capacity to 0 and stop.

*   Why Does Greedy Work Here (and Not for 0/1 Knapsack)?
    Fractional Knapsack: Because you can take fractional parts, packing items with the highest value-per-pound ratio guarantees 
    that every unit of capacity used yields maximum potential value. This demonstrates the Greedy Choice Property and Optimal Substructure.

    0/1 Knapsack: Choosing highest ratio items might leave empty "gaps" in capacity that cannot be filled because items cannot be split. 
    Hence, 0/1 Knapsack requires Dynamic Programming or Backtracking.

 */

import java.util.Arrays;

class Item {                        // Making a class to , Make pair of weight and value Array together
    double value;                       // Taking DataType double , to store values in Fractions too 
    double weight;

    public Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Fractional_Knapsack_Problem {
    public static double getMaxValue(double capacity, Item[] items) {
        
        Arrays.sort(items, (a, b) -> {                              // Sort items by value-to-weight ratio in descending order
            double r1 = a.value / a.weight;                         //  calculating ratio of Values Per weight
            double r2 = b.value / b.weight;
            return Double.compare(r2, r1);                           // Descending order
        });

        double totalValue = 0.0;                                        // Variable to Store total value

        for (Item currelement : items) {                                       // For every element in items Array
            if (capacity <= 0) {                                        // When capacity of bag is exhausted
                break;
            }

            if (currelement.weight <= capacity) {                              // When current element 's whole weight is less than capacity
                capacity -= currelement.weight;                                // Take full item
                totalValue += currelement.value;                               // Get &  update the total value
            } 
            else {                                                              // Take a fraction of the item
                double fraction = capacity / currelement.weight;                // *Checking how much elment's weight can go in remaing knapsack
                totalValue += currelement.value * fraction;                     // Take value of that part
                capacity = 0; // Knapsack is now full                           // update the capacity to empty
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),   // ratio = 6.0
            new Item(100, 20),  // ratio = 5.0
            new Item(120, 30)   // ratio = 4.0
        };
        double capacity = 50;

        double maxValue = getMaxValue(capacity, items);
        System.out.printf("Maximum value in Knapsack = %.2f%n", maxValue);
    }
}

