/*              Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
                In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i,
                and their sum is equal to zero.

 */

package ARRAYS.HARD;

import java.util.*;

public class Three_Sum {
    public static List < List <Integer>> sum(int arr[]){

        int n = arr.length ;

        List <List <Integer>> result = new ArrayList<>();           // making a double list to store -> the list which consists of triplets
        for(int i = 0 ; i < n ; i ++){
            HashSet <Integer> set = new HashSet<>() ;

            for( int j = i+1 ; j < n ; j ++){           // starting from i + 1 , because to prevent using the same index twice
                int required = -(arr[i] + arr[j]) ;

                if(set.contains(required)){                         // if set have required( third element)
                    List<Integer> triplet = new ArrayList<>();      // list to store the triplets

                    triplet.add(arr[i]);
                    triplet.add(arr[j]);
                    triplet.add(arr[required]);             // add it to triplet

                    result.add(triplet);
                }
                set.add(arr[j]) ;           // else, add current element to set
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
        int arr[] = { -1,0,1,2,-1,-4 } ;
        System.out.print(sum(arr));
    }
}
