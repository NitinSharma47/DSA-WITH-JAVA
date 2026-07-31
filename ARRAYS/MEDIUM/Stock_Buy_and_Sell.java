/* You are given an array of prices where prices[i] is the price of a given stock on an ith day.
  You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. 
  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

  example ->
  Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note: That buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/


package ARRAYS.MEDIUM;

class Stock_Buy_and_Sell {
    public static int profit(int arr[]){
        int maxprofit = 0 ;
        int currprofit = 0 ;

        int buy = 0 , sell = 0 ;

        for(int i = 0 ; i < arr.length ; i ++){
            buy = arr[i] ;
            for( int j = i + 1; j < arr.length ; j ++){         // starting j from i+1 , because we must buy before sell....
                if(arr[j] > buy){                       // when the element is greater than the current buy price..
                    sell = arr[j] ;
                }
                currprofit = sell - buy ;                   // calculating current profit
                maxprofit = Math.max(maxprofit,currprofit) ;
            }
        }
        return maxprofit ;
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4} ;
        System.out.println(profit(arr));
    }

    
    
}
