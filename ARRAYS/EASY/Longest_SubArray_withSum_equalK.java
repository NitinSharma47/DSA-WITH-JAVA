/*               Given an array nums of size n and an integer k,
            find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.   
*/
       
       
       package ARRAYS.EASY;

import java.util.HashMap;

public class Longest_SubArray_withSum_equalK {
    public static int longest(int arr[], int k){
        

        HashMap<Integer ,Integer > map = new HashMap<>();
        map.put(0 , 1) ;

        int sum = 0 , count = 0 ;

        for(int num : arr){
            sum += num ;
        
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count ;
    }
    public static void main(String[] args) {
        int arr[] = { 4,3,5,2,1,3,3,7};
        System.out.println(longest(arr, 7));

    }

}
            
        

        
        