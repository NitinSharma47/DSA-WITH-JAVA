package ARRAYS.MEDIUM;

//*         Logic is - Any trader can only sell the stock, if its current day stock value is greater than previous days values..
//*              he only finds the cheapest price day to buy the stock.. 


public class Stock_Buy_and_Sell_optimal {
    public static int profit(int arr[]){
        int minPrice = Integer.MAX_VALUE ;
        int maxprofit = 0;

        for(int i = 0 ; i < arr.length ; i ++){    
            if(arr[i] < minPrice){              // here the main logic is , if current element is less than previous elements, then we consider it for buying(means minprice)
                minPrice = arr[i] ;
            }else{                      // and if the current element is greater than previous element , then we are calculating profits
                maxprofit = Math.max(maxprofit, arr[i] - minPrice) ;
            }
        }
        return maxprofit ;

    }
     public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4} ;
        System.out.println(profit(arr));
    }
}
