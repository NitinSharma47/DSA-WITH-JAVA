package ARRAYS.HARD;

import java.util.*;

public class Majority_Element_optimal {
    public static List<Integer> major( int arr []){

    // since there can be only maximum two elements which can be major , so lets create variables to store them & and to keep track of their count

        int n =  arr.length ;
        int element1  =  Integer.MIN_VALUE , element2 = Integer.MIN_VALUE ;
        int count1 = 0 , count2 = 0 ;       

        for(int i = 0 ; i < n ; i ++){
            if( count1 == 0 && arr[i] != element2){             // when arr[i] is unique & not already store in element 2
                count1 = 1 ;
                element1 = arr[i];
            }
            else if(count2 == 0 && arr[i] != element1){
                count2 = 1 ;
                element2 = arr[i] ;
            }
            else if(arr[i] == element1){
                count1 ++ ;
            }
            else if(arr[i] == element2){
                count2 ++ ;
            }
            else{
                count1 -- ;
                count2 -- ;
            }
        }
        int totalcount1 = 0 , totalcount2 = 0 ;         // to store the total counts of element 1 and element 2

        for(int j = 0 ; j < n ; j ++){
            if(arr[j] == element1){
                totalcount1 ++ ;
            }
            if(arr[j] == element2){
                totalcount2 ++ ;
            }
        }
        int mini = n / 3 + 1 ;                      // condition of question
        List<Integer> list = new ArrayList<>() ;
        if(totalcount1 >= mini){
            list.add(element1) ;
        } 
        if(totalcount2 >= mini){
            list.add(element2) ;
        }

        return list ;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,1,3,1,1,2,2} ;
        System.out.println(major(arr));
    }
    
}
