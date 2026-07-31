package ARRAYS.MEDIUM;

import java.util.* ;

public class Leaders_In_Array_Optimal {
    public static ArrayList < Integer >  Leaders(int arr[]){

        ArrayList < Integer > ans = new ArrayList<>() ;
        if(arr.length == 0){            // when array is empty
            return ans ;
        }
        int n =  arr.length ;
        int max = arr[n-1] ;       // initialising the last element to max variable for comparisons

        ans.add(arr[n-1]);       // add the last element to list, because it is a leader

        for(int i = n - 2 ; i >= 0 ; i --){         //iterate from last
            if(arr[i] > max){
                ans.add(arr[i]) ;
                max = arr[i];           // update max , whenever any leader is found
            }
        }
        Collections.reverse(ans);   // to make the order of list elements in matching to array elements
        return ans ;
    }
     public static void main(String[] args) {
        int arr [] = {10, 22, 12, 3, 0, 6} ;
        System.out.println(Leaders(arr));
    }
    
}
